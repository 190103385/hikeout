package com.example.hikeout.dto;

import com.example.hikeout.domains.Favorite;
import com.example.hikeout.domains.Review;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
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
    private List<Review> reviews;

    @Getter
    private List<Favorite> favorites;
}
