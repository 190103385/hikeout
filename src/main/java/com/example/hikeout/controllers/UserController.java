package com.example.hikeout.controllers;

import com.example.hikeout.domains.User;
import com.example.hikeout.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServiceImpl service;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", service.getAllUsers());

        return "users-view";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);

        return "redirect:/users";
    }

    @GetMapping("/{id}/block")
    public String blockUser(@PathVariable Long id) {
        service.blockUser(id);

        return "redirect:/users";
    }

    @GetMapping("/{id}/unblock")
    public String unblockUser(@PathVariable Long id) {
        service.unblockUser(id);

        return "redirect:/users";
    }

    @GetMapping("{id}/admin")
    public String makeAdmin(@PathVariable Long id) {
        service.makeAdmin(id);

        return "redirect:/users/moderators";
    }

    @GetMapping("/moderators")
    public String getAllModerators(Model model) {
        model.addAttribute("moderators", service.getAllModerators());

        return "moderators-view";
    }

    @GetMapping("/moderators/{id}/delete")
    public String deleteAdmin(@PathVariable Long id) {
        service.deleteAdmin(id);

        return "redirect:/users/moderators";
    }

}
