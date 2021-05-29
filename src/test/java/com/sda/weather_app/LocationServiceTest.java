package com.sda.weather_app;

import com.sda.weather_app.weather_app.Location;
import com.sda.weather_app.weather_app.LocationRepository;
import com.sda.weather_app.weather_app.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class LocationServiceTest {

    LocationService locationService;

    @BeforeEach
    public void setUp() {
        LocationRepository locationRepository = new LocationRepositoryMock();
        locationService = new LocationService(locationRepository);
    }

    @Test
    public void whenCreateNewLocation_givenCorrectValues_thenCreatesNewLocation() {
        // when
        Location result = locationService.createNewLocation("city", "region", "country", 10, 12);

        // then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getCity()).isEqualTo("city");
        assertThat(result.getRegion()).isEqualTo("region");
        assertThat(result.getCountry()).isEqualTo("country");
        assertThat(result.getLongitude()).isEqualTo(10);
        assertThat(result.getLatitude()).isEqualTo(12);
    }

    @Test
    public void whenCreateNewLocation_regionIsBlank_thenCreatesNewLocation() {
        // when
        Location result = locationService.createNewLocation("city", "  ", "country", 10, 12);

        // then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getCity()).isEqualTo("city");
        assertThat(result.getRegion()).isNull();
        assertThat(result.getCountry()).isEqualTo("country");
        assertThat(result.getLongitude()).isEqualTo(10);
        assertThat(result.getLatitude()).isEqualTo(12);
    }

    @Test
    public void whenCreateNewLocation_cityIsEmpty_throwsAnException() {
        //when
        Throwable result = catchThrowable(() -> locationService.createNewLocation("", "region", "country", 10, 10));

        //then
        assertThat(result).isExactlyInstanceOf(RuntimeException.class);
    }

    @Test
    public void whenCreateNewLocation_cityIsBlank_throwsAnException() {
        //when
        Throwable result = catchThrowable(() -> locationService.createNewLocation("   ", "region", "country", 10, 10));

        //then
        assertThat(result).isExactlyInstanceOf(RuntimeException.class);
    }

    @Test
    public void whenCreateNewLocation_longitudeIsGreaterThan180_throwsAnException() {
        //when
        Throwable result = catchThrowable(() -> locationService.createNewLocation("city", "region", "country", 181, 10));

        //then
        assertThat(result).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
