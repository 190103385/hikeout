package com.example.hikeout.repositories;

import com.example.hikeout.domains.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String name);

    Optional<Category> findCategoryById(Long id);

    @Transactional
    void deleteCategoryById(Long id);
}
