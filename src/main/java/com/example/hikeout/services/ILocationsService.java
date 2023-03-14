package com.example.hikeout.services;

import com.example.hikeout.dto.LocationDto;

import java.util.List;

public interface ILocationsService {
    List<LocationDto> getAllLocations();
}
