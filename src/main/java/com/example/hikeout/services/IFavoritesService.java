package com.example.hikeout.services;

import com.example.hikeout.domains.Favorite;
import com.example.hikeout.dto.FavoritesDto;

import java.util.List;

public interface IFavoritesService {
    List<FavoritesDto> getAllFavoritesByUserId(Long id);

    void saveToFavorites(FavoritesDto request);
}
