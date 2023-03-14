package com.example.hikeout.services.impl;

import com.example.hikeout.dto.CategoryDto;
import com.example.hikeout.mappers.CategoryToDto;
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
                .stream().map(mapper :: toCategoryDto)
                .toList();
    }
}
