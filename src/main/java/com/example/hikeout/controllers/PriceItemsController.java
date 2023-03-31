package com.example.hikeout.controllers;

import com.example.hikeout.dto.PriceItemDto;
import com.example.hikeout.services.IPriceItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/priceItems")
public class PriceItemsController {
    @Autowired
    IPriceItemsService service;

    @GetMapping
    public List<PriceItemDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public List<PriceItemDto> findAllByLocationId(@PathVariable Long id) {
        return service.findAllByLocationId(id);
    }

    @GetMapping("/{id}/max")
    public int getMaxAmount(@PathVariable Long id) {
        return service.getMaxAmount(id);
    }

    @GetMapping("/{id}/min")
    public int getMinAmount(@PathVariable Long id) {
        return service.getMinAmount(id);
    }

    @PutMapping
    public void upsertPriceItem(@RequestBody PriceItemDto request) {
        service.upsertItem(request);
    }

    @DeleteMapping("/{id}")
    public void deletePriceItemById(@PathVariable Long id) {
        service.deleteItemById(id);
    }
}
