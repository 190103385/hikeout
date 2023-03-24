package com.example.hikeout.controllers;

import com.example.hikeout.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    IUserService service;

    @GetMapping("/{email}")
    public UserDetails getUserByEmail(@PathVariable String email) {
       return service.loadUserByUsername(email);
    }
}
