package com.example.hikeout.dto;

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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long locationId;

    @Getter
    private Long userId;
}
