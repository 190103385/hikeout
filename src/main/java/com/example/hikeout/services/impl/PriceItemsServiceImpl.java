package com.example.hikeout.services.impl;

import com.example.hikeout.domains.PriceItem;
import com.example.hikeout.dto.PriceItemDto;
import com.example.hikeout.dto.mappers.PriceItemToDto;
import com.example.hikeout.repositories.LocationRepository;
import com.example.hikeout.repositories.PriceItemsRepository;
import com.example.hikeout.services.IPriceItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of interface PriceItems service.
 */
@Service
public class PriceItemsServiceImpl implements IPriceItemsService {
    @Autowired
    PriceItemsRepository repository;

    @Autowired
    LocationRepository locationRepository;
    @Autowired
    PriceItemToDto mapper;

    /**
     * Get all price items and turn to DTO.
     */
    @Override
    public List<PriceItemDto> findAll() {
        return repository.findAll().stream().map(mapper::toPriceItemDto).toList();
    }

    /**
     * Get all price items by location and price less than given parameter and turn to DTO.
     */
    @Override
    public List<PriceItemDto> findAllByLocationAndPriceIsLessThan(String location, int price) {
        return repository.findAllByLocationNameContainsAndPriceIsLessThanEqualOrderById(location, price).stream().map(mapper::toPriceItemDto).toList();
    }

    /**
     * Get all price items by location name and turn to DTO.
     */
    @Override
    public List<PriceItemDto> findAllByLocationName(String location) {
        return repository.findAllByLocationNameContains(location).stream().map(mapper::toPriceItemDto).toList();
    }

    /**
     * Get all price items with price less than given parameter and turn to DTO.
     */
    @Override
    public List<PriceItemDto> findAllByPriceIsLessThan(int price) {
        return repository.findAllByPriceLessThanEqual(price).stream().map(mapper::toPriceItemDto).toList();
    }

    /**
     * Get price item by ID.
     */
    @Override
    public PriceItem getById(Long id) {
        return repository.findPriceItemById(id).orElseThrow();
    }

    /**
     * Get price items by location ID.
     */
    @Override
    public List<PriceItemDto> findAllByLocationId(Long id) {
        return repository.findAllByLocationId(id).stream().map(mapper::toPriceItemDto).toList();
    }

    /**
     * Get sum of price for price item with given ID.
     */
    @Override
    public int getMaxAmount(Long id) {
        List<PriceItemDto> priceItems = findAllByLocationId(id);

        if (priceItems.isEmpty()) {
            return 0;
        }

        int sum = 0;

        for (PriceItemDto item : priceItems) {
            sum += item.getPrice();
        }

        return sum;
    }

    /**
     * Get minimum amount for price, for price item with given ID.
     */
    @Override
    public int getMinAmount(Long id) {
        List<PriceItemDto> priceItems = findAllByLocationId(id);

        if (priceItems.isEmpty()) {
            return 0;
        }

        int min = priceItems.get(0).getPrice();

        for (PriceItemDto item : priceItems) {
            if (min > item.getPrice()) {
                min = item.getPrice();
            }
        }

        return min;
    }

    /**
     * Delete price item by ID.
     */
    @Override
    public void deleteItemById(Long id) {
        repository.deletePriceItemById(id);
    }

    /**
     * Delete price item by location ID.
     */
    @Override
    public void deleteItemByLocation(Long locationId) {
        repository.deletePriceItemByLocationId(locationId);
    }

    /**
     * Insert new price item.
     */
    @Override
    public void insertPriceItem(PriceItem item) {
        repository.save(item);
    }

    /**
     * Update existing price item.
     */
    @Override
    public void updatePriceItem(Long id, PriceItem newItem) {
        PriceItem item = repository.findPriceItemById(id).orElseThrow();

        if (newItem.getName() != null) item.setName(newItem.getName());
        if (newItem.getPrice() != 0) item.setPrice(newItem.getPrice());
        if (newItem.getLocation() != null) item.setLocation(newItem.getLocation());

        repository.save(item);
    }
}
