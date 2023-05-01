package com.example.hikeout.repositories;

import com.example.hikeout.domains.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository to fetch and delete categories.
 * */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * Finds category by category ID.
     * */
    Optional<Category> findCategoryById(Long id);

    /**
     * Delete category by ID.
     * */
    @Transactional
    void deleteCategoryById(Long id);
}
