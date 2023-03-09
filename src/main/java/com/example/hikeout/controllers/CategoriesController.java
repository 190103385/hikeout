package com.example.hikeout.controllers;

import com.example.hikeout.dto.CategoryDto;
import com.example.hikeout.services.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoriesController {

    @Autowired
    private ICategoriesService service;

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return service.getAllCategories();
    }
}
