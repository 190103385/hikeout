package com.example.hikeout.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class FavoritesDto {

    @Getter
    private Long id;

    @Getter
    private Long userId;

    @Getter
    private Long locationId;

}
