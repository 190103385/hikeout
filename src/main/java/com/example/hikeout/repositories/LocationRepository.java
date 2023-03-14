package com.example.hikeout.repositories;

import com.example.hikeout.domains.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    Location getById(Long id);

    List<Location> getByCategoryName(String category);

    List<Location> getByNameContainsIgnoreCase(String name);
}
