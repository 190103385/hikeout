package com.example.hikeout.repositories;

import com.example.hikeout.domains.Location;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> getByCategoryName(String category);

    List<Location> getByNameContainsIgnoreCase(String name);

    List<Location> getByCategoryNameAndNameContainsIgnoreCase(String category, String name);

    @Transactional
    void deleteLocationById(Long id);

    Location findTopByOrderByIdDesc();
}
