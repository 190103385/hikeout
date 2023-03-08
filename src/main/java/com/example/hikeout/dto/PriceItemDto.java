package com.example.hikeout.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class PriceItemDto {

    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private int price;

    @Getter
    private Long locationId;
}
