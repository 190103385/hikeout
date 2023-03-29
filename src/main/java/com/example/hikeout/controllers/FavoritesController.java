package com.example.hikeout.controllers;

import com.example.hikeout.domains.Favorite;
import com.example.hikeout.dto.FavoritesDto;
import com.example.hikeout.services.IFavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/favorites")
public class FavoritesController {

    @Autowired
    private IFavoritesService service;

    @GetMapping("/{userId}")
    public List<FavoritesDto> getAllFavoritesByUserId(@PathVariable Long userId) {
        return service.getAllFavoritesByUserId(userId);
    }

    @PostMapping
    public void saveToFavorites(@RequestBody FavoritesDto request) {
        service.saveToFavorites(request);
    }
}
