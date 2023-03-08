package com.example.hikeout.dto;

import com.example.hikeout.domains.Location;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CategoryDto {

    private Long id;

    private String name;

    private String icon;

    private List<Location> locations;

}
