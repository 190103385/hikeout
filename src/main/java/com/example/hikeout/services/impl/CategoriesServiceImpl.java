package com.example.hikeout.services.impl;

import com.example.hikeout.domains.Category;
import com.example.hikeout.dto.CategoryDto;
import com.example.hikeout.dto.mappers.CategoryToDto;
import com.example.hikeout.repositories.CategoryRepository;
import com.example.hikeout.services.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements ICategoriesService {

    @Autowired
    CategoryRepository repo;
    @Autowired
    CategoryToDto mapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        return repo
                .findAll()
                .stream().map(mapper::toCategoryDto)
                .toList();
    }

    @Override
    public void addCategory(Category newCategory) {
        repo.save(newCategory);
    }

    @Override
    public void updateCategory(Long id, Category newCategory) {
        Category category = repo.findCategoryById(id).orElseThrow();

        if (newCategory.getName() != null || newCategory.getName().equals("")) category.setName(newCategory.getName());

        repo.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        repo.deleteCategoryById(id);
    }

    @Override
    public Category getCategory(Long id) {
        return repo.findCategoryById(id).orElseThrow();
    }
}
