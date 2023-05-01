package com.example.hikeout.services;

import com.example.hikeout.dto.FavoritesDto;

import java.util.List;

/**
 * Interface Favorites service.
 */
public interface IFavoritesService {
    List<FavoritesDto> getAllFavoritesByUserId(Long id);

    void saveToFavorites(FavoritesDto request);

    void unfavorite(Long id);
}
