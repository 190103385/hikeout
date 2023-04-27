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

@Controller
@RequestMapping("/locations")
public class LocationsController {
    @Autowired
    ILocationsService service;

    @Autowired
    ICategoriesService categoriesService;

    @Autowired
    CategoryRepository categoryRepository;

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

    @GetMapping("/view/add")
    public String addLocationView(Model model) {
        Location location = new Location();

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("location", location);

        return "add-location-view";
    }

    @GetMapping("/view/update/{id}")
    public String updateLocationView(@PathVariable Long id, Model model) {

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("location", service.getLocationById(id));

        return "update-location-view";
    }

    @GetMapping("/{id}/delete")
    public String deleteLocation(@PathVariable Long id) {
        service.deleteLocationById(id);

        return "redirect:/locations";
    }

    @PostMapping("/update/{id}")
    public String updateLocation(@PathVariable Long id, @ModelAttribute("location") Location newLocation) {
        service.updateLocation(id, newLocation);

        return "redirect:/locations";
    }

    @PostMapping("/add")
    public String insertLocation(@ModelAttribute("location") Location location) {
        service.insertLocation(location);

        return "redirect:/locations";
    }
}
