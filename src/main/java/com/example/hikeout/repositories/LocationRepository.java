package com.example.hikeout.repositories;

import com.example.hikeout.domains.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Override
    List<Location> findAll();
}
