package com.example.hikeout.controllers;

import com.example.hikeout.domains.Location;
import com.example.hikeout.dto.LocationDto;
import com.example.hikeout.repositories.CategoryRepository;
import com.example.hikeout.services.ICategoriesService;
import com.example.hikeout.services.ILocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to fetch, add, remove and update locations in management.
 * */
@Controller
@RequestMapping("/locations")
public class LocationsController {

    /**
     * Interface Locations service. Used in almost all methods.
     * */
    @Autowired
    ILocationsService service;

    /**
     * Category repository. Used to fetch list of categories to add to model attribute.
     * */
    @Autowired
    CategoryRepository categoryRepository;

    /**
     * Take model parameter and two optional parameters: category and name.
     * If both category and name is null, takes all categories.
     * If one of them present filters by that field.
     * If both present filters by both fields. Redirect to locations-view page.
     * */
    @GetMapping
    public String getLocations(
            Model model,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "name", required = false) String name
    ) {
        List<LocationDto> locations;

        if (category != null && name != null && !name.isEmpty()) {
            locations = service.getLocationsByCategoryAndName(category, name);
        } else if (category != null) {
            locations = service.getLocationsByCategory(category);
        } else if (name != null && !name.isEmpty()) {
            locations = service.getLocationsByLocationName(name);
        } else locations = service.getAllLocations();

        model.addAttribute("locations", locations);
        model.addAttribute("categories", categoryRepository.findAll());

        return "locations-view";
    }

    /**
     * Takes model as parameter to add to it list of categories and new location. Redirects to add-locations-view page.
     * */
    @GetMapping("/view/add")
    public String addLocationView(Model model) {
        Location location = new Location();

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("location", location);

        return "add-location-view";
    }

    /**
     * Takes path variable ID and model as parameter. Add to model list of categories and location found by ID. Redirects to update-location-view page.
     * */
    @GetMapping("/view/update/{id}")
    public String updateLocationView(@PathVariable Long id, Model model) {

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("location", service.getLocationById(id));

        return "update-location-view";
    }

    /**
     * Uses method of service to delete location by variable ID given in path. Redirect to locations page.
     * */
    @GetMapping("/{id}/delete")
    public String deleteLocation(@PathVariable Long id) {
        service.deleteLocationById(id);

        return "redirect:/locations";
    }

    /**
     * Uses method from service to update location found by ID given in path. Redirect to locations page.
     * */
    @PostMapping("/update/{id}")
    public String updateLocation(@PathVariable Long id, @ModelAttribute("location") Location newLocation) {
        service.updateLocation(id, newLocation);

        return "redirect:/locations";
    }

    /**
     * Uses method from service to add new location given as parameter. Redirect to locations page.
     * */
    @PostMapping("/add")
    public String insertLocation(@ModelAttribute("location") Location location) {
        service.insertLocation(location);

        return "redirect:/locations";
    }
}
