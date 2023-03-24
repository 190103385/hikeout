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

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    @Override
    public List<ReviewDto> getAllReviewsByLocationId(Long locationId) {
        return reviewsRepository.findAllByLocationId(locationId).stream()
                .map(mapper::toReviewDto).toList();
    }

    @Override
    public void createReview(ReviewDto request) {
        reviewsRepository.save(Review.builder()
                .date(LocalDateTime.now())
                .content(request.getContent())
                .location(locationRepository.findById(request.getLocationId()).orElseThrow())
                .rating(request.getRating())
                .user(userService.getCurrentlyLoggedInUser(auth))
                .build()
        );
    }
}
