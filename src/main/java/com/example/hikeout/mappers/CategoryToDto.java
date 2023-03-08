package com.example.hikeout.mappers;

import com.example.hikeout.domains.Category;
import com.example.hikeout.dto.CategoryDto;
import com.example.hikeout.repositories.LocationRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryToDto {
    LocationRepository locationRepository;

    public CategoryDto toCategoryDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getIcon(),
                category.getLocations()
        );
    }
}
