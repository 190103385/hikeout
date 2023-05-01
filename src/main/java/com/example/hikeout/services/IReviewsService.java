package com.example.hikeout.services;

import com.example.hikeout.dto.ReviewDto;

import java.util.List;

/**
 * Interface Reviews service.
 */
public interface IReviewsService {
    List<ReviewDto> getAllReviewsByLocationId(Long locationId);

    List<ReviewDto> getReviewsByLocation(String location);

    List<ReviewDto> getAllReviews();

    void createReview(ReviewDto request);

    void deleteReviewById(Long id);
}
