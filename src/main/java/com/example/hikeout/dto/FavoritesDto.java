package com.example.hikeout.dto;

import com.example.hikeout.domains.Location;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class FavoritesDto {

    @Getter
    private Long id;

    @Getter
    private Long userId;

    @Getter
    private Long locationId;

}
