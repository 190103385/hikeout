package com.example.hikeout.services.impl;

import com.example.hikeout.domains.Location;
import com.example.hikeout.dto.LocationDto;
import com.example.hikeout.dto.mappers.LocationToDto;
import com.example.hikeout.repositories.LocationRepository;
import com.example.hikeout.services.ILocationsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public LocationDto getLocationById(Long id) {
        Optional<Location> locationOptional = locationRepository.findById(id);
        if (locationOptional.isEmpty()) {
            throw new EntityNotFoundException("Location with id [" + id + "] not found");
        }
        return mapper.toLocationDto(locationOptional.get());
    }

    @Override
    public List<LocationDto> getLocationsByCategory(String category) {
        List<Location> locations = locationRepository.getByCategoryName(category);

        return locations.stream().map(mapper::toLocationDto).toList();
    }

    @Override
    public List<LocationDto> getLocationsByLocationName(String name) {
        List<Location> locations = locationRepository.getByNameContainsIgnoreCase(name);

        return locations.stream().map(mapper::toLocationDto).toList();
    }

    @Override
    public List<LocationDto> getLocationsByCategoryAndName(String cateogry, String name) {
        List<Location> locations = locationRepository.getByCategoryNameAndNameContainsIgnoreCase(cateogry, name);

        return locations.stream().map(mapper::toLocationDto).toList();
    }
}
