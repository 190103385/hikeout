package com.example.hikeout.controllers;

import com.example.hikeout.dto.LocationDto;
import com.example.hikeout.services.ILocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
