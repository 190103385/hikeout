package com.example.hikeout.controllers;

import com.example.hikeout.domains.User;
import com.example.hikeout.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserServiceImpl service;

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    @GetMapping
    public UserDetails getUserByEmail(@RequestParam(value = "email") String email) {
       return service.loadUserByUsername(email);
    }
    @GetMapping("/{id}")
    public UserDetails getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping("/current")
    public String getCurrentUser() {
        return service.getCurrentlyLoggedInUser(authentication).getUsername();
    }
}
