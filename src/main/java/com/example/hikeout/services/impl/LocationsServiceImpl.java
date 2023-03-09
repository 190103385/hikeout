package com.example.hikeout.services.impl;

import com.example.hikeout.domains.Location;
import com.example.hikeout.dto.LocationDto;
import com.example.hikeout.mappers.LocationToDto;
import com.example.hikeout.repositories.LocationRepository;
import com.example.hikeout.services.ILocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsServiceImpl implements ILocationsService {

    @Autowired
    LocationRepository locationRepository;
    @Autowired
    LocationToDto mapper;

    @Override
    public List<LocationDto> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream().map(mapper::toLocationDto).toList();
    }
}
