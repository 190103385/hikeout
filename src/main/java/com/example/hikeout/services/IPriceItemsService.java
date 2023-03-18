package com.example.hikeout.services;

import com.example.hikeout.dto.PriceItemDto;

import java.util.List;

public interface IPriceItemsService {

    List<PriceItemDto> findAll();

    List<PriceItemDto> findAllByLocationId(Long id);

    int getMaxAmount(Long id);

    int getMinAmount(Long id);
}
