package com.example.hikeout.services;

import com.example.hikeout.domains.User;
import com.example.hikeout.dto.AuthenticationResponse;
import com.example.hikeout.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService {
    UserDetails loadUserByUsername(String email);
}
