package com.example.hikeout.dto.mappers;

import com.example.hikeout.domains.Location;
import com.example.hikeout.dto.LocationDto;
import com.example.hikeout.repositories.PriceItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationToDto {

    @Autowired
    PriceItemsRepository priceItemsRepository;

    public LocationDto toLocationDto(Location location) {
        if (location == null) return null;

        return new LocationDto(
                location.getId(),
                location.getName(),
                location.getDescription(),
                location.getIcon(),
                location.getWorksFrom(),
                location.getWorksTill(),
                location.getIsActive(),
                location.getLat(),
                location.getLon(),
                priceItemsRepository.findAllByLocationId(location.getId()),
                location.getFavorite() != null,
                location.getReviews(),
                location.getCategory()
        );
    }

}
