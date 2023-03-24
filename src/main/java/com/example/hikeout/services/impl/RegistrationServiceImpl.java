package com.example.hikeout.services.impl;

import com.example.hikeout.domains.User;
import com.example.hikeout.dto.AuthenticationResponse;
import com.example.hikeout.dto.UserDto;
import com.example.hikeout.services.IRegistrationService;
import com.example.hikeout.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements IRegistrationService {

    private final IUserService userService;
    private EmailValidatorServiceImpl emailValidator;
}
