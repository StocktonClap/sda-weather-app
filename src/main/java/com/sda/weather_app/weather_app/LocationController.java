package com.sda.weather_app.weather_app;

public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    public String createNewLocation(String city, String region, String country, float longitude, float latitude) {
        try {
            Location newLocation = locationService.createNewLocation(city, region, country, longitude, latitude);
            // todo use new ObjectMapper -> alt + enter -> add Maven dependency
            // fail on unknown property -> false
            return "{\"id\": " + newLocation.getId() + " , \"city\": \"" + newLocation.getCity() + "\", \"region\": \"" + newLocation.getRegion() + "\", " +
                    "\"country\": \"" + newLocation.getCountry() + "\", \"longitude\": \"" + newLocation.getLongitude() + "\", \"latitude\": \"" + newLocation.getLatitude() + "\"}";
        } catch (RuntimeException e) {
            return "{\"error massage\": \"" + e.getMessage() + "\"}";
        }
    }
}
