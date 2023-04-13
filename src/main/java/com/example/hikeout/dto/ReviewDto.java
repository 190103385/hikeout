package com.example.hikeout.dto;

import com.example.hikeout.domains.Location;
import com.example.hikeout.domains.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ReviewDto {

    @Getter
    private Long id;

    @Getter
    private int rating;

    @Getter
    private String content;

    @Getter
    private LocalDateTime date;

    @Getter
    private Location location;

    @Getter
    private User user;
}
