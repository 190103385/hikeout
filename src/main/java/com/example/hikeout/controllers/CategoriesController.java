package com.example.hikeout.controllers;

import com.example.hikeout.domains.Category;
import com.example.hikeout.services.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to fetch, add, remove or update categories in management.
 * */
@Controller
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    ICategoriesService service;

    /**
     * Redirect to categories-view.html file.
     *
     * Take model as parameter and add to model list of all categories.
     *
     * Uses method from service to get all categories.*/
    @GetMapping
    public String getAllCategories(Model model) {
        model.addAttribute("categories", service.getAllCategories());

        return "categories-view";
    }

    /**
     * Redirect to add-category-view page for adding new categories.
     * Take model as a paramter and add to model new category.
     * */
    @GetMapping("/view/add")
    public String addCategoryView(Model model) {
        Category category = new Category();

        model.addAttribute("category", category);

        return "add-category-view";
    }
    /**
     * Take model attribute category from front. Uses addCategory method from service and redirect to categories page.
     * */
    @PostMapping("/add")
    public String insertCategory(@ModelAttribute("category") Category category) {
        service.addCategory(category);

        return "redirect:/categories";
    }

    /**
     * Take category ID as a path variable and model. Add to model a category found by previous ID and redirect to update-category-view page.
     * */
    @GetMapping("/view/update/{id}")
    public String updateCategoryView(@PathVariable Long id, Model model) {
        model.addAttribute("category", service.getCategory(id));

        return "update-category-view";
    }

    /**
     * Take category ID as path variable and model attribute category from front. Uses method from service to update and redirects to categories page.
     * */
    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable Long id, @ModelAttribute("category") Category newCategory) {
        service.updateCategory(id, newCategory);

        return "redirect:/categories";
    }

    /**
     * Take category ID as path variable parameter, uses method from service to delete and redirects to categories page.
     * */
    @GetMapping("/{id}/delete")
    public String deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);

        return "redirect:/categories";
    }
}
