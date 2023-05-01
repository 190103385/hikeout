package com.example.hikeout.restcontrollers;

import com.example.hikeout.domains.Location;
import com.example.hikeout.dto.FavoritesDto;
import com.example.hikeout.services.IFavoritesService;
import com.example.hikeout.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/favorites")
public class RestFavoritesController {

    @Autowired
    private IFavoritesService service;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping()
    public List<FavoritesDto> getAllFavoritesByUserId() {
        return service.getAllFavoritesByUserId(userService.getCurrentlyLoggedInUser().getId());
    }

    @PostMapping
    public void saveToFavorites(@RequestBody FavoritesDto request) {
        service.saveToFavorites(request);
    }

    @DeleteMapping("/{id}")
    public void unfavorite(@PathVariable Long id) {
        service.unfavorite(id);
    }
}
