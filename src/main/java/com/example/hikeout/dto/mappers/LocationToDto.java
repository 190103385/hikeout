package com.example.hikeout.dto.mappers;

import com.example.hikeout.domains.Location;
import com.example.hikeout.dto.LocationDto;
import org.springframework.stereotype.Component;

@Component
public class LocationToDto {

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
                location.getPriceItems().stream().filter(item ->
                                item.getLocation().getId()
                                        .equals(location.getId()))
                        .toList(),
                location.getFavorite() != null,
                location.getReviews(),
                location.getCategory().getName()
        );
    }

}
