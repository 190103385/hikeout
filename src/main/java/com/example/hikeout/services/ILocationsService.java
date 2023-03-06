package com.example.hikeout.services;

import com.example.hikeout.dto.LocationDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILocationsService {
    List<LocationDto> getAllLocations();
}
