package com.example.hikeout.restcontrollers;

import com.example.hikeout.dto.PriceItemDto;
import com.example.hikeout.services.IPriceItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for price items.
 * */
@RestController
@RequestMapping("api/priceItems")
public class RestPriceItemsController {

    /**
     * Interface PriceItems service.
     * */
    @Autowired
    IPriceItemsService service;

    /**
     * Get all price items.
     * */
    @GetMapping
    public List<PriceItemDto> findAll() {
        return service.findAll();
    }

    /**
     * Get all price items by location ID.
     * */
    @GetMapping("/{id}")
    public List<PriceItemDto> findAllByLocationId(@PathVariable Long id) {
        return service.findAllByLocationId(id);
    }

    /**
     * Get price item with the highest value for price.
     * */
    @GetMapping("/{id}/max")
    public int getMaxAmount(@PathVariable Long id) {
        return service.getMaxAmount(id);
    }

    /**
     * Get price item with the lowest value for price
     * */
    @GetMapping("/{id}/min")
    public int getMinAmount(@PathVariable Long id) {
        return service.getMinAmount(id);
    }

    /**
     * Delete price item by ID.
     * */
    @DeleteMapping("/{id}")
    public void deletePriceItemById(@PathVariable Long id) {
        service.deleteItemById(id);
    }
}
