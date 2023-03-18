package com.example.hikeout.services.impl;

import com.example.hikeout.dto.PriceItemDto;
import com.example.hikeout.dto.mappers.PriceItemToDto;
import com.example.hikeout.repositories.PriceItemsRepository;
import com.example.hikeout.services.IPriceItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceItemsServiceImpl implements IPriceItemsService {
    @Autowired
    PriceItemsRepository repository;
    @Autowired
    PriceItemToDto mapper;

    @Override
    public List<PriceItemDto> findAll() {
        return repository.findAll().stream().map(mapper::toPriceItemDto).toList();
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
}
