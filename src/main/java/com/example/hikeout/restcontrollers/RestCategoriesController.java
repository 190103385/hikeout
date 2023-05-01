package com.example.hikeout.restcontrollers;

import com.example.hikeout.domains.Category;
import com.example.hikeout.dto.CategoryDto;
import com.example.hikeout.services.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for categories.
 * */
@RestController
@RequestMapping("api/categories")
public class RestCategoriesController {

    /**
     * Interface Categories service.
     * */
    @Autowired
    private ICategoriesService service;

    /**
     * Get all categories.
     * */
    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return service.getAllCategories();
    }

    /**
     * Add new category.
     * */
    @PostMapping
    public void addCategory(@RequestBody Category request) {
        service.addCategory(request);
    }
}
