package com.example.hikeout.repositories;

import com.example.hikeout.domains.Favorite;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to fetch and delete favorites.
 * */
@Repository
public interface FavoritesRepository extends JpaRepository<Favorite, Long> {

    /**
     * Finds all favorites by given ID.
     * */
    List<Favorite> findAllByUserId(Long userId);

    /**
     * Delete favorite by given ID.
     * */
    @Transactional
    void deleteFavoriteById(Long id);
}
