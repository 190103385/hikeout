package com.example.hikeout.services.impl;

import com.example.hikeout.domains.Favorite;
import com.example.hikeout.domains.Location;
import com.example.hikeout.dto.FavoritesDto;
import com.example.hikeout.dto.LocationDto;
import com.example.hikeout.dto.mappers.FavoritesToDto;
import com.example.hikeout.repositories.FavoritesRepository;
import com.example.hikeout.repositories.LocationRepository;
import com.example.hikeout.services.IFavoritesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesService implements IFavoritesService {

    @Autowired
    private FavoritesRepository repository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private FavoritesToDto mapper;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public List<FavoritesDto> getAllFavoritesByUserId(Long id) {
        return repository.findAllByUserId(id).stream().map(mapper::toFavoritesDto).toList();
    }

    @Override
    public void saveToFavorites(FavoritesDto request) {
        repository.save(Favorite.builder()
                .user(userService.getCurrentlyLoggedInUser())
                .location(locationRepository.findById(request.getLocationId()).orElseThrow())
                .build());
    }

    @Override
    public void unfavorite(Long id) {
        repository.deleteFavoriteById(id);
    }
}
