package com.example.hikeout.repositories;

import com.example.hikeout.domains.Location;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to fetch and delete locations.
 * */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    /**
     * Finds all locations ordered by ID in ascending order.
     * */
    List<Location> findAllByOrderByIdAsc();

    /**
     * Finds all locations by given category name.
     * */
    List<Location> getByCategoryName(String category);

    /**
     * Finds all locations containing given name ignoring case.
     * */
    List<Location> getByNameContainsIgnoreCase(String name);

    /**
     * Finds all locations by given category name and location name ignoring case.
     * */
    List<Location> getByCategoryNameAndNameContainsIgnoreCase(String category, String name);

    /**
     * Delete location by given ID.
     * */
    @Transactional
    void deleteLocationById(Long id);
}
