package com.sda.weather;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class LocationService {

    private final LocationRepository locationRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public Location createNewLocation(String city, String region, String country, float longitude, float latitude) {
        if (city == null || city.isBlank()) {
            throw new RuntimeException("City name can't be empty!");
        }
        if (country == null || country.isBlank()) {
            throw new RuntimeException("Country name can't be empty!");
        }
        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Longitude: parameters did not pass validation as defined: min -180, max 180");
        }
        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Latitude: parameters did not pass validation as defined: min -90, max 90");
        }
        if (region.isBlank()) {
            region = null;
        }

        Location newLocation = new Location(null, city, region, country, longitude, latitude);

        return locationRepository.save(newLocation);
    }

    public List<Location> getAllLocations() {
        List<Location> locationList = locationRepository.getAllLocations();
        if (locationList.isEmpty()) {
            throw new RuntimeException("Database is empty");
        }
        return locationList;
    }
}
