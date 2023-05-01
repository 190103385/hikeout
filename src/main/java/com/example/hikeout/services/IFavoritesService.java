package com.example.hikeout.services;

import com.example.hikeout.domains.Location;
import com.example.hikeout.dto.FavoritesDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface IFavoritesService {
    List<FavoritesDto> getAllFavoritesByUserId(Long id);

    void saveToFavorites(FavoritesDto request);

    void unfavorite(Long id);
}
