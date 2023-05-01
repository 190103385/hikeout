package com.example.hikeout.restcontrollers;

import com.example.hikeout.domains.User;
import com.example.hikeout.dto.UserDto;
import com.example.hikeout.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for users.
 * */
@RestController
@RequestMapping("api/users")
public class RestUserController {

    /**
     * User service.
     * */
    @Autowired
    UserServiceImpl service;

    /**
     * Get all users.
     * */
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    /**
     * Get user by email.
     * */
    @GetMapping
    public UserDetails getUserByEmail(@RequestParam(value = "email") String email) {
        return service.loadUserByUsername(email);
    }

    /**
     * Get user by user ID.
     * */
    @GetMapping("/{id}")
    public UserDetails getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    /**
     * Get currently logged-in user.
     * */
    @GetMapping("/current")
    public String getCurrentUser() {
        return service.getCurrentlyLoggedInUser().getUsername();
    }

    /**
     * Edit existing user.
     * */
    @PutMapping
    public void editUser(@RequestBody UserDto request) {
        service.editUser(request);
    }
}
