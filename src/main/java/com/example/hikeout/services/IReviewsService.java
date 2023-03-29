package com.example.hikeout.services;

import com.example.hikeout.dto.ReviewDto;

import java.util.List;

public interface IReviewsService {
    List<ReviewDto> getAllReviewsByLocationId(Long locationId);

    void createReview(ReviewDto request);
}
