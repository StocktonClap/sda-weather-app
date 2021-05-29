package com.sda.weather;

public class WeatherApplication {

    public static void main(String[] args) {
        LocationRepositoryImpl locationRepository = new LocationRepositoryImpl();
        LocationService locationService = new LocationService(locationRepository);
        LocationController locationController = new LocationController(locationService);
        UserInterface userInterface = new UserInterface(locationController);
        userInterface.run();
    }
}

