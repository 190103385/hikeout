package com.example.hikeout.controllers;

import com.example.hikeout.services.IReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller to fetch and delete reviews in management.
 * */
@Controller
@RequestMapping("/reviews")
public class ReviewsController {

    /**
     * Interface Reviews service. Used in all methods for various reasons.
     * */
    @Autowired
    IReviewsService service;

    /**
     * Fetch all reviews, if optional param name is null.
     * Else filter by location name.
     * */
    @GetMapping
    public String getAllReviews(Model model, @RequestParam(value = "name", required = false) String name) {

        if (name != null && !name.isEmpty()) {
            model.addAttribute("reviews", service.getReviewsByLocation(name));
        } else model.addAttribute("reviews", service.getAllReviews());

        return "reviews-view";
    }

    /**
     * Delete review.
     * */
    @GetMapping("/{id}/delete")
    public String deleteReview(@PathVariable Long id) {
        service.deleteReviewById(id);

        return "redirect:/reviews";
    }
}
