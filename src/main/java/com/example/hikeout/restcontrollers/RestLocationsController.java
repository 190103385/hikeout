package com.example.hikeout.restcontrollers;

import com.example.hikeout.dto.LocationDto;
import com.example.hikeout.services.ILocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for locations.
 * */
@RestController
@RequestMapping("api/locations")
public class RestLocationsController {

    /**
     * Interface Locations service.
     * */
    @Autowired
    private ILocationsService service;

    /**
     * Get all locations, if opt params are null.
     * Filter by request params, if either one or both of them are present.
     * */
    @GetMapping
    public List<LocationDto> getLocations(
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "name", required = false) String name
    ) {
        if (category != null && name != null) {
            return service.getLocationsByCategoryAndName(category, name);
        } else if (category != null) {
            return service.getLocationsByCategory(category);
        } else if (name != null) {
            return service.getLocationsByLocationName(name);
        }

        return service.getAllLocations();
    }

    /**
     * Get location by given ID.
     * */
    @GetMapping("/{id}")
    public LocationDto getLocationById(@PathVariable Long id) {
        return service.getLocationById(id);
    }

    /**
     * Delete location by given ID.
     * */
    @DeleteMapping("/{id}")
    public void deleteLocationById(@PathVariable Long id) {
        service.deleteLocationById(id);
    }
}
