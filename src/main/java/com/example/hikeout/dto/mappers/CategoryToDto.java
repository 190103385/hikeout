package com.example.hikeout.dto.mappers;

import com.example.hikeout.domains.Category;
import com.example.hikeout.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryToDto {

    public CategoryDto toCategoryDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getIcon(),
                category.getLocations());
    }
}
