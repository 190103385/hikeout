package com.example.hikeout.mappers;

import com.example.hikeout.domains.Favorite;
import com.example.hikeout.dto.FavoritesDto;
import org.springframework.stereotype.Component;

@Component
public class FavoritesToDto {
    public FavoritesDto toFavoritesDto(Favorite favorite) {
        return new FavoritesDto(
                favorite.getId(),
                favorite.getUser().getId(),
                favorite.getLocation().getId());
    }
}
