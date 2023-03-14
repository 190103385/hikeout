package com.example.hikeout.services;

import com.example.hikeout.dto.CategoryDto;

import java.util.List;

public interface ICategoriesService {
    List<CategoryDto> getAllCategories();
}
