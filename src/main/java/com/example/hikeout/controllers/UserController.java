package com.example.hikeout.controllers;

import com.example.hikeout.domains.UserRole;
import com.example.hikeout.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller to fetch, update, remove, add users, create and delete moderators in management.
 * */
@Controller
@RequestMapping("/users")
public class UserController {

    /**
     * User Service. Used in all methods.
     * */
    @Autowired
    UserServiceImpl service;

    /**
     * Fetch all users, if opt param is null.
     * Else filter by name.
     * */
    @GetMapping
    public String getAllUsers(Model model, @RequestParam(value = "name", required = false) String name) {

        if (name != null && !name.isEmpty()) {
            model.addAttribute("users", service.getUsersByUsername(name, UserRole.USER));
        } else model.addAttribute("users", service.getAllUsers());

        return "users-view";
    }

    /**
     * Delete user.
     * */
    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);

        return "redirect:/users";
    }

    /**
     * Block user.
     * */
    @GetMapping("/{id}/block")
    public String blockUser(@PathVariable Long id) {
        service.blockUser(id);

        return "redirect:/users";
    }

    /**
     * Unblock user.
     * */
    @GetMapping("/{id}/unblock")
    public String unblockUser(@PathVariable Long id) {
        service.unblockUser(id);

        return "redirect:/users";
    }

    /**
     * Change user role to ADMIN
     * */
    @GetMapping("{id}/admin")
    public String makeAdmin(@PathVariable Long id) {
        service.makeAdmin(id);

        return "redirect:/users/moderators";
    }

    /**
     * Fetch all users with ADMIN role, if opt param is null.
     * Else all users with ADMIN role and filtered by name.
     * */
    @GetMapping("/moderators")
    public String getAllModerators(Model model, @RequestParam(value = "name", required = false) String name) {

        if (name != null && !name.isEmpty()) {
            model.addAttribute("moderators", service.getUsersByUsername(name, UserRole.ADMIN));
        } else model.addAttribute("moderators", service.getAllModerators());

        return "moderators-view";
    }

    /**
     * Change user role to USER.
     * */
    @GetMapping("/moderators/{id}/delete")
    public String deleteAdmin(@PathVariable Long id) {
        service.deleteAdmin(id);

        return "redirect:/users/moderators";
    }

}
