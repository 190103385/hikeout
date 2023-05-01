package com.example.hikeout.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to visit management page.
 * */
@Controller
@RequestMapping("/management")
public class ManagementController {

    /**
     * Redirects to management page
     * */
    @GetMapping
    public String getManagement() {
        return "management";
    }
}
