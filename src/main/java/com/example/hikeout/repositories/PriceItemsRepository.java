package com.example.hikeout.repositories;

import com.example.hikeout.domains.PriceItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PriceItemsRepository extends JpaRepository<PriceItem, Long> {
    List<PriceItem> findAllByLocationId(Long id);

    Optional<PriceItem> findPriceItemById(Long id);

    List<PriceItem> findAllByLocationNameContainsAndPriceIsLessThanEqualOrderById(String location, int price);

    List<PriceItem> findAllByLocationNameContains(String location);

    List<PriceItem> findAllByPriceLessThanEqual(int price);

    @Transactional
    void deletePriceItemById(Long id);

    @Transactional
    void deletePriceItemByLocationId(Long locationId);
}
