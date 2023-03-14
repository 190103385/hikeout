package com.example.hikeout.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties(value = "priceItems")
    private Long locationId;
}
