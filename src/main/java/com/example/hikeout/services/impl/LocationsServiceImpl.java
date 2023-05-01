package com.example.hikeout.services.impl;

import com.example.hikeout.domains.Location;
import com.example.hikeout.dto.LocationDto;
import com.example.hikeout.dto.mappers.LocationToDto;
import com.example.hikeout.repositories.LocationRepository;
import com.example.hikeout.services.ILocationsService;
import com.example.hikeout.services.IPriceItemsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of interface Locations service.
 */
@Service
public class LocationsServiceImpl implements ILocationsService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    IPriceItemsService priceItemsService;
    @Autowired
    LocationToDto mapper;

    /**
     * Get all locations and map to DTO.
     */
    @Override
    public List<LocationDto> getAllLocations() {
        List<Location> locations = locationRepository.findAllByOrderByIdAsc();
        return locations.stream().map(mapper::toLocationDto).toList();
    }

    /**
     * Get location by ID and turn to DTO.
     */
    @Override
    public LocationDto getLocationById(Long id) {
        Optional<Location> locationOptional = locationRepository.findById(id);
        if (locationOptional.isEmpty()) {
            throw new EntityNotFoundException("Location with id [" + id + "] not found");
        }
        return mapper.toLocationDto(locationOptional.get());
    }

    /**
     * Get locations by category and turn to DTO.
     */
    @Override
    public List<LocationDto> getLocationsByCategory(String category) {
        List<Location> locations = locationRepository.getByCategoryName(category);

        return locations.stream().map(mapper::toLocationDto).toList();
    }

    /**
     * Get locations by name and turn to DTO.
     */
    @Override
    public List<LocationDto> getLocationsByLocationName(String name) {
        List<Location> locations = locationRepository.getByNameContainsIgnoreCase(name);

        return locations.stream().map(mapper::toLocationDto).toList();
    }

    /**
     * Get locations by category and location name and turn to DTO.
     */
    @Override
    public List<LocationDto> getLocationsByCategoryAndName(String category, String name) {
        List<Location> locations = locationRepository.getByCategoryNameAndNameContainsIgnoreCase(category, name);

        return locations.stream().map(mapper::toLocationDto).toList();
    }

    /**
     * Delete location by ID.
     */
    @Override
    public void deleteLocationById(Long id) {
        priceItemsService.deleteItemByLocation(id);
        locationRepository.deleteLocationById(id);
    }

    /**
     * Save new location.
     */
    @Override
    public void insertLocation(Location newLocation) {
        locationRepository.save(newLocation);
    }

    /**
     * Update existing location.
     */
    @Override
    public void updateLocation(Long id, Location newLocation) {
        Location location = locationRepository.findById(id).orElseThrow();

        if(newLocation.getName() != null) location.setName(newLocation.getName());
        if(newLocation.getDescription() != null) location.setDescription(newLocation.getDescription());
        if(newLocation.getIcon() != null) location.setIcon(newLocation.getIcon());
        if(newLocation.getCategory() != null) location.setCategory(newLocation.getCategory());
        if(newLocation.getWorksFrom() != null) location.setWorksFrom(newLocation.getWorksFrom());
        if(newLocation.getWorksTill() != null) location.setWorksTill(newLocation.getWorksTill());
        location.setLat(newLocation.getLat());
        location.setLon(newLocation.getLon());

        locationRepository.save(location);
    }
}
