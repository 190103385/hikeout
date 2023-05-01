package com.example.hikeout.restcontrollers;

import com.example.hikeout.dto.LocationDto;
import com.example.hikeout.services.ILocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/locations")
public class RestLocationsController {

    @Autowired
    private ILocationsService service;

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

    @GetMapping("/{id}")
    public LocationDto getLocationById(@PathVariable Long id) {
        return service.getLocationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLocationById(@PathVariable Long id) {
        service.deleteLocationById(id);
    }
}
