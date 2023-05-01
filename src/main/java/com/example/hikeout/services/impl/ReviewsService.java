package com.example.hikeout.services.impl;

import com.example.hikeout.domains.Review;
import com.example.hikeout.dto.ReviewDto;
import com.example.hikeout.dto.mappers.ReviewToDto;
import com.example.hikeout.repositories.ReviewsRepository;
import com.example.hikeout.services.IReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementation of interface Reviews service.
 */
@Service
public class ReviewsService implements IReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ReviewToDto mapper;

    /**
     * Get all reviews by location ID.
     */
    @Override
    public List<ReviewDto> getAllReviewsByLocationId(Long locationId) {
        return reviewsRepository.findAllByLocationId(locationId).stream()
                .map(mapper::toReviewDto).toList();
    }

    /**
     * Get all reviews by location name.
     */
    @Override
    public List<ReviewDto> getReviewsByLocation(String location) {
        return reviewsRepository.findAllByLocationNameOrderById(location).stream().map(mapper::toReviewDto).toList();
    }

    /**
     * Get all reviews.
     */
    @Override
    public List<ReviewDto> getAllReviews() {
        return reviewsRepository.findAll().stream().map(mapper::toReviewDto).toList();
    }

    /**
     * Create new review.
     */
    @Override
    public void createReview(ReviewDto request) {
        reviewsRepository.save(Review.builder()
                .date(LocalDateTime.now())
                .content(request.getContent())
                .location(request.getLocation())
                .rating(request.getRating())
                .user(userService.getCurrentlyLoggedInUser())
                .build()
        );
    }

    /**
     * Delete review by ID.
     */
    @Override
    public void deleteReviewById(Long id) {
        reviewsRepository.deleteReviewById(id);
    }
}
