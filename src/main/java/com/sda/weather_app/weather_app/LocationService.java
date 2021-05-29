package com.sda.weather_app.weather_app;

import java.util.Optional;

public class LocationService {

    private final LocationRepository locationRepository; // todo just LocationRepository

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location createNewLocation(String city, String region, String country, float longitude, float latitude) {
        //todo - data validation - just call methods
        if (!LocationValidator.isValidLongitude(longitude) &&
                !LocationValidator.isValidLatitude(latitude) &&
                !LocationValidator.isValidCityName(city) &&
                !LocationValidator.isValidCountryName(country)) {
            throw new IllegalArgumentException("The parameters did not pass validation as defined by the LocationValidator class");
        }

        Location newLocation = new Location(null, city, region, country, longitude, latitude); // todo set region as a null value

        // todo region -> "     "
        //  set region if value is correct newLocation.setRegion(value);
        //  Optional.ofNullable(region).filter(...).ifPresent(...)

        return locationRepository.save(newLocation);
    }

    static class LocationValidator {

        public static boolean isValidLatitude(float latitude) {
            if (latitude >= MIN_LATITUDE && latitude <= MAX_LATITUDE) {
                return true;
            } else {
                throw new IllegalArgumentException("Latitude: parameters did not pass validation as defined");
            }
        }

        public static boolean isValidLongitude(float longitude) {
            if (longitude >= MIN_LONGITUDE && longitude <= MAX_LONGITUDE) {
                return true;
            } else {
                throw new IllegalArgumentException("Longitude: parameters did not pass validation as defined!");
            }
        }

        // the minimum allowed latitude
        public static float MIN_LATITUDE = -90.0000F;

        // the maximum allowed latitude
        public static float MAX_LATITUDE = 90.0000F;

        // the minimum allowed longitude
        public static float MIN_LONGITUDE = -180.0000F;

        // the maximum allowed longitude
        public static float MAX_LONGITUDE = 180.0000F;

        public static boolean isValidCityName(String city) {
            if (city == null || city.isEmpty()) { // todo isBlank
                throw new RuntimeException("Field city can't be null or empty!");
            }
            return true;
        }

        public static boolean isValidCountryName(String country) {
            if (country == null || country.isEmpty()) {
                throw new RuntimeException("Field country can't be null or empty!");
            }
            return true;
        }
    }
}
