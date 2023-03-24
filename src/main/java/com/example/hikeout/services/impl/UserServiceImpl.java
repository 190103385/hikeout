package com.example.hikeout.services.impl;

import com.example.hikeout.domains.User;
import com.example.hikeout.dto.AuthenticationResponse;
import com.example.hikeout.dto.UserDto;
import com.example.hikeout.dto.mappers.UserToDto;
import com.example.hikeout.repositories.UserRepository;
import com.example.hikeout.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService, UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", email))
        );
    }
}
