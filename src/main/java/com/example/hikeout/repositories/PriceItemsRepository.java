package com.example.hikeout.repositories;

import com.example.hikeout.domains.PriceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceItemsRepository extends JpaRepository<PriceItem, Long> {
    List<PriceItem> findAllByLocationId(Long id);

    List<PriceItem> findPriceItemByLocationIdOrderByPriceDesc(Long id);
}