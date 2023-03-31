package com.example.hikeout.controllers;

import com.example.hikeout.dto.LocationDto;
import com.example.hikeout.services.ILocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/locations")
public class LocationsController {

    @Autowired
    private ILocationsService service;

//    @GetMapping
//    public List<LocationDto> getLocations(
//            Model model,
//            @RequestParam(value = "category", required = false) String category,
//            @RequestParam(value = "name", required = false) String name
//    ) {
//        if(category != null && name != null) {
//            return service.getLocationsByCategoryAndName(category, name);
//        }
//        else if(category != null) {
//            return service.getLocationsByCategory(category);
//        }
//        else if(name != null) {
//            return service.getLocationsByLocationName(name);
//        }
//
//        model.addAttribute("locations", service.getAllLocations());
//
//        return service.getAllLocations();
//    }

    @GetMapping
    public String getLocations(
            Model model,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "name", required = false) String name
    ) {
        List<LocationDto> locations = null;

        if(category != null && name != null) {
            locations = service.getLocationsByCategoryAndName(category, name);
        }
        else if(category != null) {
            locations = service.getLocationsByCategory(category);
        }
        else if(name != null) {
            locations = service.getLocationsByLocationName(name);
        }

        model.addAttribute("locations", locations);

        return "locations";
    }

    @GetMapping("/{id}")
    public LocationDto getLocationById(@PathVariable Long id) {
        return service.getLocationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLocationById(@PathVariable Long id) {
        service.deleteLocationById(id);
    }

    @PutMapping
    public void updateLocation(@RequestBody LocationDto request) {
        service.upsertLocation(request);
    }
}
