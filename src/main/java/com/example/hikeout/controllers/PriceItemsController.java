package com.example.hikeout.controllers;

import com.example.hikeout.domains.PriceItem;
import com.example.hikeout.repositories.PriceItemsRepository;
import com.example.hikeout.services.ILocationsService;
import com.example.hikeout.services.IPriceItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/priceItems")
public class PriceItemsController {
    @Autowired
    IPriceItemsService service;
    @Autowired
    ILocationsService locationsService;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("priceItems", service.findAll());

        return "price-items-view";
    }

    @GetMapping("/view/add")
    public String addPriceItemView(Model model) {
        PriceItem item = new PriceItem();

        model.addAttribute("priceItem", item);
        model.addAttribute("locations", locationsService.getAllLocations());

        return "add-price-item-view";
    }

    @GetMapping("/add")
    public String addPriceItem(@ModelAttribute("priceItem") PriceItem item) {
        service.insertPriceItem(item);

        return "redirect:/priceItems";
    }

    @GetMapping("/view/update/{id}")
    public String updatePriceItemView(@PathVariable Long id, Model model) {
        model.addAttribute("priceItem", service.getById(id));
        model.addAttribute("locations", locationsService.getAllLocations());

        return "update-price-item-view";
    }

    @PostMapping("/update/{id}")
    public String updatePriceItem(@PathVariable Long id, @ModelAttribute("priceItem") PriceItem newItem) {
        service.updatePriceItem(id, newItem);

        return "redirect:/priceItems";
    }
}
