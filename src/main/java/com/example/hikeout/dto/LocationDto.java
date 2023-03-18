package com.example.hikeout.dto;

import com.example.hikeout.domains.PriceItem;
import com.example.hikeout.domains.Review;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {

    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private String description;

    @Getter
    private String icon;

    @Getter
    private String worksFrom;

    @Getter
    private String worksTill;

    @Getter
    private Boolean isActive;

    @Getter
    private Double lat;

    @Getter
    private Double lon;

    @Getter
    @JsonIgnoreProperties({"location", "id"})
    private List<PriceItem> priceItems;

    @Getter
    private Boolean isFavorite;

    @Getter
    @JsonIgnoreProperties({"user", "location", "id"})
    private List<Review> reviews;

    @Getter
    private String category;
}
