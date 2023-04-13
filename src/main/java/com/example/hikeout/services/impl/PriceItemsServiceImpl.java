package com.example.hikeout.services.impl;

import com.example.hikeout.domains.Location;
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

@Service
public class PriceItemsServiceImpl implements IPriceItemsService {
    @Autowired
    PriceItemsRepository repository;

    @Autowired
    LocationRepository locationRepository;
    @Autowired
    PriceItemToDto mapper;

    @Override
    public List<PriceItemDto> findAll() {
        return repository.findAll().stream().map(mapper::toPriceItemDto).toList();
    }

    @Override
    public PriceItem getById(Long id) {
        return repository.findPriceItemById(id).orElseThrow();
    }

    @Override
    public List<PriceItemDto> findAllByLocationId(Long id) {
        return repository.findAllByLocationId(id).stream().map(mapper::toPriceItemDto).toList();
    }

    @Override
    public int getMaxAmount(Long id) {
        List<PriceItemDto> priceItems = findAllByLocationId(id);

        if(priceItems.isEmpty()) {
            return 0;
        }

        int sum = 0;

        for(PriceItemDto item : priceItems) {
            sum += item.getPrice();
        }

        return sum;
    }

    @Override
    public int getMinAmount(Long id) {
        List<PriceItemDto> priceItems = findAllByLocationId(id);

        if(priceItems.isEmpty()) {
            return 0;
        }

        int min = priceItems.get(0).getPrice();

        for(PriceItemDto item : priceItems) {
            if(min > item.getPrice()) {
                min = item.getPrice();
            }
        }

        return min;
    }

    @Override
    public void upsertItem(PriceItemDto newPriceItem) {
        Optional<PriceItem> priceItemOptional = repository.findById(newPriceItem.getId());
        PriceItem item;

        if (priceItemOptional.isEmpty()) {
            item = new PriceItem();
        } else {
            item = priceItemOptional.get();
        }

        item.setName(newPriceItem.getName());
        item.setPrice(newPriceItem.getPrice());
        item.setLocation(locationRepository.findById(newPriceItem.getLocation().getId()).orElseThrow());

        repository.save(item);
    }

    @Override
    public void deleteItemById(Long id) {
        repository.deletePriceItemById(id);
    }

    @Override
    public void deleteItemByLocation(Long locationId) {
        repository.deletePriceItemByLocationId(locationId);
    }

    @Override
    public void insertPriceItem(PriceItem item) {
        repository.save(item);
    }

    @Override
    public void updatePriceItem(Long id, PriceItem newItem) {
        PriceItem item = repository.findPriceItemById(id).orElseThrow();

        if(newItem.getName() != null) item.setName(newItem.getName());
        if(newItem.getPrice() != 0) item.setPrice(newItem.getPrice());
        if(newItem.getLocation() != null) item.setLocation(newItem.getLocation());

        repository.save(item);
    }
}
