package com.example.hikeout.services;

import com.example.hikeout.dto.LocationDto;

import java.util.List;
import java.util.Optional;

public interface ILocationsService {
    List<LocationDto> getAllLocations();

    LocationDto getLocationById(Long id);

    List<LocationDto> getLocationsByCategory(String category);

    List<LocationDto> getLocationsByLocationName(String name);
}
