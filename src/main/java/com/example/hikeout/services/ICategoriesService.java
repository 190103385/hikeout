package com.example.hikeout.services;

import com.example.hikeout.domains.Category;
import com.example.hikeout.dto.CategoryDto;

import java.util.List;

/**
 * Interface Categories service.
 */
public interface ICategoriesService {
    Category getCategory(Long id);

    List<CategoryDto> getAllCategories();

    void addCategory(Category newCategory);

    void updateCategory(Long id, Category newCategory);

    void deleteCategory(Long id);
}
