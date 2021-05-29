package com.sda.weather_app;

import com.sda.weather_app.weather_app.Location;
import com.sda.weather_app.weather_app.LocationRepository;

import java.util.ArrayList;
import java.util.List;

public class LocationRepositoryMock implements LocationRepository {

    private List<Location> locations = new ArrayList<>();

    @Override
    public Location save (Location location) {
        location.setId(1L);
        locations.add(location);
        return location;
    }
}
