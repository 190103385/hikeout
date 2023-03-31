package com.example.hikeout.dto.mappers;

import com.example.hikeout.domains.PriceItem;
import com.example.hikeout.dto.PriceItemDto;
import org.springframework.stereotype.Component;

@Component
public class PriceItemToDto {
    public PriceItemDto toPriceItemDto(PriceItem priceItem) {
        return new PriceItemDto(
                priceItem.getId(),
                priceItem.getName(),
                priceItem.getPrice(),
                priceItem.getLocation());
    }
}
