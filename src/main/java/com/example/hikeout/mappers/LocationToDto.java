package com.example.hikeout.mappers;

import com.example.hikeout.domains.Location;
import com.example.hikeout.dto.LocationDto;
import org.springframework.stereotype.Component;

@Component
public class LocationToDto {

    public LocationDto toLocationDto(Location location) {
        return new LocationDto(
                location.getId(),
                location.getName(),
                location.getId());
    }

}
