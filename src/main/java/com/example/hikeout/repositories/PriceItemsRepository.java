package com.example.hikeout.repositories;

import com.example.hikeout.controllers.PriceItemsController;
import com.example.hikeout.domains.PriceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PriceItemsRepository extends JpaRepository<PriceItem, Long> {

//    @Query( "SELECT pi FROM PriceItem pi JOIN pi.location.id pg WHERE bk.bookId = :bookId")
//    List<PriceItem> findAllByLocation_Id(Long locationId);

    List<PriceItem> findAllByLocationId(@Param("location_id") Long id);
}
