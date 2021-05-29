package com.sda.weather_app.weather_app;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // domyślnie AUTO -> wybiera pomiędzy IDENTITY, SEQUENCE, TABLE na podstawie drivera -> SEQUENCE dla MySQLA
    private Long id;

    private String city;
    private String region;
    private String country;
    private float longitude;
    private float latitude;

    public Location() {
    }

    public Location(Long id, String city, String region, String country, float longitude, float latitude) {
        this.id = id;
        this.city = city;
        this.region = region;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
