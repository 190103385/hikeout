package com.example.hikeout.services.impl;

import com.example.hikeout.domains.User;
import com.example.hikeout.dto.UserDto;
import com.example.hikeout.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", email))
        );
    }

    public UserDetails getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findUserById(id);

        if(optionalUser.isEmpty()) {
            throw new EntityNotFoundException("No such user");
        }

        return optionalUser.get();
    }

    public User getCurrentlyLoggedInUser(Authentication authentication) {
        if (authentication == null) return null;

        User user = null;
        Object principal = authentication.getPrincipal();

        if(principal instanceof UserDetails) {
            user = userRepository.findByEmail(((User) principal).getUsername()).orElseThrow();
        }

        return user;
    }
}
