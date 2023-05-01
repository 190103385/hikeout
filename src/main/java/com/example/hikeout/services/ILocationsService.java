package com.example.hikeout.services;

import com.example.hikeout.domains.Location;
import com.example.hikeout.dto.LocationDto;

import java.util.List;

/**
 * Interface Locations service.
 */
public interface ILocationsService {
    List<LocationDto> getAllLocations();

    LocationDto getLocationById(Long id);

    List<LocationDto> getLocationsByCategory(String category);

    List<LocationDto> getLocationsByLocationName(String name);

    List<LocationDto> getLocationsByCategoryAndName(String category, String name);

    void deleteLocationById(Long id);

    void insertLocation(Location newLocation);

    void updateLocation(Long id, Location newLocation);
}
