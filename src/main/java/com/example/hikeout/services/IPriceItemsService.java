package com.example.hikeout.services;

import com.example.hikeout.domains.PriceItem;
import com.example.hikeout.dto.PriceItemDto;

import java.util.List;

public interface IPriceItemsService {

    List<PriceItemDto> findAll();

    PriceItem getById(Long id);

    List<PriceItemDto> findAllByLocationId(Long id);

    int getMaxAmount(Long id);

    int getMinAmount(Long id);

    void upsertItem(PriceItemDto request);

    void deleteItemById(Long id);

    void deleteItemByLocation(Long locationId);

    void insertPriceItem(PriceItem item);

    void updatePriceItem(Long id, PriceItem newItem);
}
