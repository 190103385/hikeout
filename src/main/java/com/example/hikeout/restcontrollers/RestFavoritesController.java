package com.example.hikeout.restcontrollers;

import com.example.hikeout.domains.Location;
import com.example.hikeout.dto.FavoritesDto;
import com.example.hikeout.services.IFavoritesService;
import com.example.hikeout.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for favorites.
 * */
@RestController
@RequestMapping("api/favorites")
public class RestFavoritesController {

    /**
     * Interface Favorites service.
     * */
    @Autowired
    private IFavoritesService service;

    /**
     * User service.
     * */
    @Autowired
    private UserServiceImpl userService;

    /**
     * Get all favorites of currently logged-in user.
     * */
    @GetMapping()
    public List<FavoritesDto> getAllFavoritesByUserId() {
        return service.getAllFavoritesByUserId(userService.getCurrentlyLoggedInUser().getId());
    }

    /**
     * Add new item to favorites.
     * */
    @PostMapping
    public void saveToFavorites(@RequestBody FavoritesDto request) {
        service.saveToFavorites(request);
    }

    /**
     * Delete from favorites.
     * */
    @DeleteMapping("/{id}")
    public void unfavorite(@PathVariable Long id) {
        service.unfavorite(id);
    }
}
