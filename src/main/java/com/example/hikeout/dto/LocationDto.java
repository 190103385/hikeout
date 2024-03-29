package com.example.hikeout.dto;

import com.example.hikeout.domains.Category;
import com.example.hikeout.domains.Location;
import com.example.hikeout.domains.PriceItem;
import com.example.hikeout.domains.Review;
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
    private List<PriceItem> priceItems;

    @Getter
    private Boolean isFavorite;

    @Getter
    private List<Review> reviews;

    @Getter
    private Category category;
}
