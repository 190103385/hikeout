package com.example.hikeout.repositories;

import com.example.hikeout.domains.Favorite;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findAllByUserId(Long userId);
    @Transactional
    void deleteFavoriteById(Long id);
}
