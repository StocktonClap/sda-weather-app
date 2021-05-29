package com.sda.weather_app;

public class LocationController {

    private LocationService locationService = new LocationService();

    public String createNewLocation(String city, String region, String country, float longitude, float latitude) {
        //todo
        try {
            Location newLocation = locationService.createNewLocation(city, region, country, longitude, latitude);
            return "{\"id\": " + newLocation.getId() + " , \"city\": \"" + newLocation.getCity() + "\", \"region\": \"" + newLocation.getRegion() + "\", " +
                    "\"country\": \"" + newLocation.getCountry() + "\", \"longitude\": \"" + newLocation.getLongitude() + "\", \"latitude\": \"" + newLocation.getLatitude() + "\"}";
        } catch (RuntimeException e) {
            return "{\"error massage\": \"" + e.getMessage() + "\"}";
        }
    }
}
