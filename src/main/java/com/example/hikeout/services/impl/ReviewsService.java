package com.example.hikeout.services.impl;

import com.example.hikeout.domains.Review;
import com.example.hikeout.dto.ReviewDto;
import com.example.hikeout.dto.mappers.ReviewToDto;
import com.example.hikeout.repositories.LocationRepository;
import com.example.hikeout.repositories.ReviewsRepository;
import com.example.hikeout.services.IReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewsService implements IReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ReviewToDto mapper;

    @Override
    public List<ReviewDto> getAllReviewsByLocationId(Long locationId) {
        return reviewsRepository.findAllByLocationId(locationId).stream()
                .map(mapper::toReviewDto).toList();
    }

    @Override
    public List<ReviewDto> getAllReviews() {
        return reviewsRepository.findAll().stream().map(mapper::toReviewDto).toList();
    }

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

    @Override
    public void editReview(ReviewDto request) {
        Review review = reviewsRepository.findById(request.getId()).orElseThrow();

        review.setRating(request.getRating());
        review.setContent(request.getContent());

        reviewsRepository.save(review);
    }

    @Override
    public void deleteReviewById(Long id) {
        reviewsRepository.deleteReviewById(id);
    }
}
