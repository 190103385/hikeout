package com.example.hikeout.restcontrollers;

import com.example.hikeout.domains.Category;
import com.example.hikeout.dto.CategoryDto;
import com.example.hikeout.services.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class RestCategoriesController {

    @Autowired
    private ICategoriesService service;

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return service.getAllCategories();
    }

    @PostMapping
    public void addCategory(@RequestBody Category request) {
        service.addCategory(request);
    }
}
