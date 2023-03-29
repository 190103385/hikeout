package com.example.hikeout.repositories;

import com.example.hikeout.domains.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewsRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByLocationId(Long locationId);
}
