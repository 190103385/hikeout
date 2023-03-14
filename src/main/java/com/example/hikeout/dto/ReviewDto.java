package com.example.hikeout.dto;

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
    private Long locationId;

    @Getter
    private Long userId;
}
