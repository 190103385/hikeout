package com.example.hikeout.dto;

import com.example.hikeout.domains.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private Long categoryId;
}
