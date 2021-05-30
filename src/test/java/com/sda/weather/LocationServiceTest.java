package com.sda.weather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class LocationServiceTest {

    LocationService locationService;
    LocationRepository locationRepository;

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
        assertThat(result.getRegion()).isBlank();
        assertThat(result.getCountry()).isEqualTo("country");
        assertThat(result.getLongitude()).isEqualTo(10);
        assertThat(result.getLatitude()).isEqualTo(12);
    }

    @Test
    public void whenCreateNewLocation_regionIsEmpty_thenCreatesNewLocation() {
        // when
        Location result = locationService.createNewLocation("city", "", "country", 10, 12);

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
    public void whenCreateNewLocation_cityIsNull_throwsAnException() {
        //when
        Throwable result = catchThrowable(() -> locationService.createNewLocation(null, "region", "country", 10, 10));

        //then
        assertThat(result).isExactlyInstanceOf(RuntimeException.class);
    }

    @Test
    public void whenCreateNewLocation_countryIsEmpty_throwsAnException() {
        //when
        Throwable result = catchThrowable(() -> locationService.createNewLocation("city", "region", "", 10, 10));

        //then
        assertThat(result).isExactlyInstanceOf(RuntimeException.class);
    }

    @Test
    public void whenCreateNewLocation_countryIsBlank_throwsAnException() {
        //when
        Throwable result = catchThrowable(() -> locationService.createNewLocation("city", "region", "  ", 10, 10));

        //then
        assertThat(result).isExactlyInstanceOf(RuntimeException.class);
    }

    @Test
    public void whenCreateNewLocation_countryIsNull_throwsAnException() {
        //when
        Throwable result = catchThrowable(() -> locationService.createNewLocation("city", "region", null, 10, 10));

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

    @Test
    public void whenCreateNewLocation_longitudeIsSmallerThan180_throwsAnException() {
        //when
        Throwable result = catchThrowable(() -> locationService.createNewLocation("city", "region", "country", -181, 10));

        //then
        assertThat(result).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenCreateNewLocation_latitudeIsGreaterThan90_throwsAnException() {
        //when
        Throwable result = catchThrowable(() -> locationService.createNewLocation("city", "region", "country", 10, 91));

        //then
        assertThat(result).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenCreateNewLocation_latitudeIsSmallerThan90_throwsAnException() {
        //when
        Throwable result = catchThrowable(() -> locationService.createNewLocation("city", "region", "country", 10, -91));

        //then
        assertThat(result).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getAllLocations_DataBaseHasSomeValues_returnThoseValues() {
        // TODO
        // given
        locationRepository.clear();
        locationRepository.save(new Location());
        locationRepository.save(new Location());
        // when
        List<Location> locationList = locationService.getAllLocations();
        //then
    }
}
