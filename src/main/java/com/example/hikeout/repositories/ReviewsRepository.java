package com.example.hikeout.repositories;

import com.example.hikeout.domains.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewsRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByLocationId(Long locationId);

    List<Review> findAllByLocationNameOrderById(String location);

    @Transactional
    void deleteReviewById(Long id);
}
