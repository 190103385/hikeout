package com.example.hikeout.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;
}
