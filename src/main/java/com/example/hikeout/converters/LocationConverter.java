package com.example.hikeout.converters;

import com.example.hikeout.domains.Location;
import com.example.hikeout.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LocationConverter implements Converter<String, Location> {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location convert(String request) {
        Long id = Long.valueOf(request);
        return locationRepository.findById(id).orElseThrow();
    }
}