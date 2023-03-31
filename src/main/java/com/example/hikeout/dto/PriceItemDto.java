package com.example.hikeout.dto;

import com.example.hikeout.domains.Location;
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
    private Location location;
}
