package com.example.hikeout.controllers;

import com.example.hikeout.dto.LocationDto;
import com.example.hikeout.dto.ReviewDto;
import com.example.hikeout.services.IReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reviews")
public class ReviewsController {

    @Autowired
    private IReviewsService service;

    @GetMapping("/{locationId}")
    public List<ReviewDto> getReviewsByLocationId(@PathVariable Long locationId) {
        return service.getAllReviewsByLocationId(locationId);
    }

    @PostMapping
    public void createReview(@RequestBody ReviewDto request) {
        service.createReview(request);
    }
}
