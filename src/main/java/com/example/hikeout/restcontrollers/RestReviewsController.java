package com.example.hikeout.restcontrollers;

import com.example.hikeout.dto.ReviewDto;
import com.example.hikeout.services.IReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for reviews.
 * */
@RestController
@RequestMapping("api/reviews")
public class RestReviewsController {

    /**
     * Interface Reviews service.
     * */
    @Autowired
    private IReviewsService service;

    /**
     * Get all reviews by location ID.
     * */
    @GetMapping("/{locationId}")
    public List<ReviewDto> getReviewsByLocationId(@PathVariable Long locationId) {
        return service.getAllReviewsByLocationId(locationId);
    }

    /**
     * Create new review.
     * */
    @PostMapping
    public void createReview(@RequestBody ReviewDto request) {
        service.createReview(request);
    }

    /**
     * Delete review by ID.
     * */
    @DeleteMapping("/{id}")
    public void deleteReviewById(@PathVariable Long id) {
        service.deleteReviewById(id);
    }
}
