package com.example.hikeout.controllers;

import com.example.hikeout.domains.Category;
import com.example.hikeout.domains.Location;
import com.example.hikeout.services.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    ICategoriesService service;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("categories", service.getAllCategories());

        return "categories-view";
    }

    @GetMapping("/view/add")
    public String addCategoryView(Model model) {
        Category category = new Category();

        model.addAttribute("category", category);

        return "add-category-view";
    }

    @PostMapping("/add")
    public String insertCategory(@ModelAttribute("category") Category category) {
        service.addCategory(category);

        return "redirect:/categories";
    }

    @GetMapping("/view/update/{id}")
    public String updateCategoryView(@PathVariable Long id, Model model) {
        model.addAttribute("category", service.getCategory(id));

        return "update-category-view";
    }

    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable Long id, @ModelAttribute("category") Category newCategory) {
        service.updateCategory(id, newCategory);

        return "redirect:/categories";
    }

    @GetMapping("/{id}/delete")
    public String deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);

        return "redirect:/categories";
    }
}
