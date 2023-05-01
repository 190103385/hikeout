package com.example.hikeout.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Service for email validation
 */
@Service
public class EmailValidatorServiceImpl implements Predicate<String> {
    @Autowired
    UserServiceImpl userService;

    /**
     * Uses regex to check if given email is valid or not.
     */
    @Override
    public boolean test(String email) {
        String regexPattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

        return Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE).matcher(email).matches();
    }
}
