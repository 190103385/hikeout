package com.example.hikeout.controllers;

import com.example.hikeout.domains.PriceItem;
import com.example.hikeout.dto.PriceItemDto;
import com.example.hikeout.services.ILocationsService;
import com.example.hikeout.services.IPriceItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to fetch, add, update, remove price items in management.
 * */
@Controller
@RequestMapping("/priceItems")
public class PriceItemsController {
    @Autowired
    IPriceItemsService service;
    @Autowired
    ILocationsService locationsService;

    /**
     * Fetch all price items, if optional parameters name and price are empty.
     * If name present, returns elements containing name.
     * If price present, returns elements which price is less than parameter.
     * */
    @GetMapping
    public String getAllPriceItems(Model model,
                                   @RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "price", required = false) Integer price) {

        List<PriceItemDto> priceItems;

        if (price != null && name != null && !name.isEmpty()) {
            priceItems = service.findAllByLocationAndPriceIsLessThan(name, price);
        } else if (price != null) {
            priceItems = service.findAllByPriceIsLessThan(price);
        } else if (name != null && !name.isEmpty()) {
            priceItems = service.findAllByLocationName(name);
        } else priceItems = service.findAll();

        model.addAttribute("priceItems", priceItems);

        return "price-items-view";
    }

    /**
     * Redirect to add-price-item-view page. Add to model new price item and list of locations.
     * */
    @GetMapping("/view/add")
    public String addPriceItemView(Model model) {
        PriceItem item = new PriceItem();

        model.addAttribute("priceItem", item);
        model.addAttribute("locations", locationsService.getAllLocations());

        return "add-price-item-view";
    }

    /**
     * Adds new price item.
     * */
    @PostMapping("/add")
    public String addPriceItem(@ModelAttribute("priceItem") PriceItem item) {
        service.insertPriceItem(item);

        return "redirect:/priceItems";
    }

    /**
     * Redirects to update-price-item-view page. Add to model price item found by ID and list of all locations.
     * */
    @GetMapping("/view/update/{id}")
    public String updatePriceItemView(@PathVariable Long id, Model model) {
        model.addAttribute("priceItem", service.getById(id));
        model.addAttribute("locations", locationsService.getAllLocations());

        return "update-price-item-view";
    }

    /**
     * Update price item with model attribute price item.
     * */
    @PostMapping("/update/{id}")
    public String updatePriceItem(@PathVariable Long id, @ModelAttribute("priceItem") PriceItem newItem) {
        service.updatePriceItem(id, newItem);

        return "redirect:/priceItems";
    }

    /**
     * Delete price item by ID.
     * */
    @GetMapping("/delete/{id}")
    public String deletePriceItem(@PathVariable Long id) {
        service.deleteItemById(id);

        return "redirect:/priceItems";
    }
}
