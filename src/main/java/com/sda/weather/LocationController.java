package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationController {

    private final LocationService locationService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    public String createNewLocation(String city, String region, String country, float longitude, float latitude) {
        try {
            Location newLocation = locationService.createNewLocation(city, region, country, longitude, latitude);
            return objectMapper.writeValueAsString(newLocation);
        } catch (Exception e) {
            return "{\"error massage\": \"" + e.getMessage() + "\"}";
        }
    }
}
