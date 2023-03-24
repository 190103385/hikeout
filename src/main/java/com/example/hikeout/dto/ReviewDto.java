package com.example.hikeout.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Long locationId;

    @Getter
    private Long userId;
}
