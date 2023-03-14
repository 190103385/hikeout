package com.example.hikeout.repositories;

import com.example.hikeout.domains.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> getByCategoryName(String category);

    List<Location> getByNameContainsIgnoreCase(String name);

    List<Location> getByCategoryNameAndName(String category, String name);
}
