package com.example.hikeout.dto;

import com.example.hikeout.domains.Favorite;
import com.example.hikeout.domains.Review;
import com.example.hikeout.domains.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Getter
    private Long id;

    @Getter
    private String email;

    @Getter
    private String password;

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    @Getter
    private String phone;

    @Getter
    private LocalDateTime createdAt;

    @Getter
    private LocalDateTime modifiedAt;

    @Getter
    private Boolean isLocked;

    @Getter
    private Boolean isEnabled;

    @Getter
    @Enumerated
    private UserRole role;

    @Getter
    @Setter
    @JsonIgnore
    private List<Review> reviews;

    @Getter
    private List<Favorite> favorites;
}
