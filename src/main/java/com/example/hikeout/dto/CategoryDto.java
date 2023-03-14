package com.example.hikeout.dto;

import com.example.hikeout.domains.Location;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private String icon;

    @Getter
    @JsonIgnoreProperties(value = "category")
    private List<Location> locations;

}
