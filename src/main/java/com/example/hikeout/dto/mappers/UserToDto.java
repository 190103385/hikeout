package com.example.hikeout.dto.mappers;

import com.example.hikeout.domains.User;
import com.example.hikeout.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserToDto {
    public UserDto toUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getCreatedAt(),
                user.getModifiedAt(),
                user.isAccountNonLocked(),
                user.isEnabled(),
                user.getRole(),
                user.getReviews(),
                user.getFavorites()
        );
    }
}
