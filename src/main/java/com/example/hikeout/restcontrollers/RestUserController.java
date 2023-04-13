package com.example.hikeout.restcontrollers;

import com.example.hikeout.domains.User;
import com.example.hikeout.dto.UserDto;
import com.example.hikeout.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class RestUserController {

    @Autowired
    UserServiceImpl service;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

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
        return service.getCurrentlyLoggedInUser().getUsername();
    }

    @PutMapping
    public void editUser(@RequestBody UserDto request) {
        service.editUser(request);
    }
}
