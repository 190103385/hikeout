package com.example.hikeout.dto.mappers;

import com.example.hikeout.domains.Review;
import com.example.hikeout.dto.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewToDto {
    public ReviewDto toReviewDto(Review review) {
        return new ReviewDto(
                review.getId(),
                review.getRating(),
                review.getContent(),
                review.getDate(),
                review.getLocation().getId(),
                review.getUser().getId());
    }
}
