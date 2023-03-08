package com.example.hikeout.mappers;

import com.example.hikeout.domains.User;
import com.example.hikeout.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserToDto {
    public UserDto toUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getCreatedAt(),
                user.getModifiedAt(),
                user.getReviews()
        );
    }
}
