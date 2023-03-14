package com.example.hikeout.controllers;

import com.example.hikeout.domains.Location;
import com.example.hikeout.dto.LocationDto;
import com.example.hikeout.services.ILocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/locations")
public class LocationsController {

    @Autowired
    private ILocationsService service;

    @GetMapping
    public List<LocationDto> getAllLocations() {
        return service.getAllLocations();
    }

    @GetMapping("/id/{id}")
    public LocationDto getLocationById(@PathVariable Long id) {
        return service.getLocationById(id);
    }

    @GetMapping("/category/{category}")
    public List<LocationDto> getLocationsByCategory(@PathVariable String category) {
        return service.getLocationsByCategory(category);
    }

    @GetMapping("/name/{name}")
    public List<LocationDto> getLocationsByLocationName(@PathVariable String name) {
        return service.getLocationsByLocationName(name);
    }
}
