package com.example.hikeout.services.impl;

import com.example.hikeout.configs.security.JwtService;
import com.example.hikeout.domains.User;
import com.example.hikeout.domains.UserRole;
import com.example.hikeout.dto.AuthenticationRequest;
import com.example.hikeout.dto.AuthenticationResponse;
import com.example.hikeout.dto.UserDto;
import com.example.hikeout.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final EmailValidatorServiceImpl emailValidator;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse register(UserDto request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .createdAt(LocalDateTime.now())
                .phone(request.getPhone())
                .isEnabled(true)
                .isLocked(false)
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UserRole.USER)
                .build();

        if (!emailValidator.test(user.getUsername()))
            throw new IllegalArgumentException("Invalid email");

        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
