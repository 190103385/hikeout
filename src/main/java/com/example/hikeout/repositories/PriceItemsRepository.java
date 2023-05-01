package com.example.hikeout.repositories;

import com.example.hikeout.domains.PriceItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repostory to fetch and delete price items.
 * */
@Repository
public interface PriceItemsRepository extends JpaRepository<PriceItem, Long> {

    /**
     * Finds all price items by given location ID.
     * */
    List<PriceItem> findAllByLocationId(Long id);

    /**
     * Finds price item by ID.
     * */
    Optional<PriceItem> findPriceItemById(Long id);

    /**
     * Finds all price items by given location name and price.
     * */
    List<PriceItem> findAllByLocationNameContainsAndPriceIsLessThanEqualOrderById(String location, int price);


    /**
     * Finds all price items by given location name.
     * */
    List<PriceItem> findAllByLocationNameContains(String location);

    /**
     * Finds all price items, field price is less than given price parameter.
     * */
    List<PriceItem> findAllByPriceLessThanEqual(int price);

    /**
     * Delete price item by given ID.
     * */
    @Transactional
    void deletePriceItemById(Long id);

    @Transactional
    void deletePriceItemByLocationId(Long locationId);
}
