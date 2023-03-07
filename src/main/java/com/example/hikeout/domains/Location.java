package com.example.hikeout.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    @Column(name = "icon")
    private String icon;

    @Column(name = "works_from")
    private LocalDateTime works_from;

    @Column(name = "works_till")
    private LocalDateTime works_till;

    @Column(name = "is_active")
    private Boolean is_active;

    @Column(name = "latitude")
    private Double lat;

    @Column(name = "longitude")
    private Double lon;

    @OneToMany(mappedBy = "price_items")
    private List<PriceItem> price_items;

    @OneToMany(mappedBy = "favorites")
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "reviews")
    private List<Review> reviews;
}



