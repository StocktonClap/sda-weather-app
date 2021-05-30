package com.sda.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // domyślnie AUTO -> wybiera pomiędzy IDENTITY, SEQUENCE, TABLE na podstawie drivera -> SEQUENCE dla MySQLA
    private Long id;
    private String city;
    private String region;
    private String country;
    private float longitude;
    private float latitude;

    public Location(String city, String region, String country, float longitude, float latitude) {
        this.city = city;
        this.region = region;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
