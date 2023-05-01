package com.example.hikeout.repositories;

import com.example.hikeout.domains.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository to fetch and delete reviews.
 * */
public interface ReviewsRepository extends JpaRepository<Review, Long> {

    /**
     * Finds all reviews by location ID.
     * */
    List<Review> findAllByLocationId(Long locationId);

    /**
     * Finds all reviews by location name in ascending order of ID
     * */
    List<Review> findAllByLocationNameOrderById(String location);

    /**
     * Delete reviws by ID.
     * */
    @Transactional
    void deleteReviewById(Long id);
}
