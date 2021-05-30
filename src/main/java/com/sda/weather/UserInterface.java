package com.sda.weather;

import java.util.Scanner;


public class UserInterface {

    private final LocationController locationController;

    public UserInterface(LocationController locationController) {
        this.locationController = locationController;
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("App is running!");
        System.out.println("# # # # # # # # # # # # # # # # # # # # # # # # # # # #");

        while (true) {
            System.out.println();
            System.out.println("Welcome in Weather Forecast App! What u want to do?");
            System.out.println();
            System.out.println("1. Add new location");
            System.out.println("2. Show all locations");
            System.out.println("3. Show weather forecast for location");
            System.out.println("4. Delete location from Database by Id");
            System.out.println("0. Close application");

            int response = scanner.nextInt();

            switch (response) {
                case 1:
                    addNewLocation();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    System.out.println("Weather forecast for location:");
                    break;
                case 4:
                    deleteById();
                case 0:
                    System.out.println("App shutting down... Bye");
                    return;
            }
        }
    }

    public void addNewLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("City:");
        String city = scanner.nextLine();
        System.out.println("Region:");
        String region = scanner.nextLine();
        System.out.println("Country:");
        String country = scanner.nextLine();
        System.out.println("Longitude:");
        float longitude = scanner.nextFloat();
        System.out.println("Latitude");
        float latitude = scanner.nextFloat();
        String httpResponseBody = locationController.createNewLocation(city, region, country, longitude, latitude);
        System.out.println("Server response: " + httpResponseBody);
        System.out.println();
    }

    public void showAll() {
        System.out.println("to implement");
    }

    public void deleteById() {
        System.out.println("to implement");
    }
}
