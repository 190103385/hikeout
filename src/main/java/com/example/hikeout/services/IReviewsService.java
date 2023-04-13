package com.example.hikeout.services;

import com.example.hikeout.dto.ReviewDto;

import java.util.List;

public interface IReviewsService {
    List<ReviewDto> getAllReviewsByLocationId(Long locationId);

    List<ReviewDto> getAllReviews();

    void createReview(ReviewDto request);

    void editReview(ReviewDto request);

    void deleteReviewById(Long id);
}
