package com.sda.weather;

import java.util.ArrayList;
import java.util.List;

public class LocationRepositoryMock implements LocationRepository {

    private List<Location> locationList = new ArrayList<>();

    @Override
    public Location save (Location location) {
        location.setId(1L);
        locationList.add(location);
        return location;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationList;
    }

    public void clear() {
        locationList.clear();
    }
}
