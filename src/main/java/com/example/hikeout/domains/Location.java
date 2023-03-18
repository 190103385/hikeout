package com.example.hikeout.domains;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;
@NoArgsConstructor
@Entity
@Table(name = "locations")
public class Location {

    public Location(Long id, String name) {}

    @Id
    @SequenceGenerator(
            name = "location_sequence",
            sequenceName = "location_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "location_sequence"
    )
    @Column(name = "id")
    @Getter
    private Long id;

    @Column(name = "name")
    @Getter
    private String name;

    @Column(name = "description")
    @Getter
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    @Getter
    private Category category;

    @Column(name = "icon")
    @Getter
    private String icon;

    @Column(name = "works_from")
    @Getter
    private String worksFrom;

    @Column(name = "works_till")
    @Getter
    private String worksTill;

    @Column(name = "is_active")
    @Getter
    private Boolean isActive;

    @Column(name = "latitude")
    @Getter
    private Double lat;

    @Column(name = "longitude")
    @Getter
    private Double lon;

    @OneToMany(mappedBy = "id")
    @Getter
    private List<PriceItem> priceItems;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "favorites_id", referencedColumnName = "id")
    @Getter
    private Favorite favorite;

    @OneToMany(mappedBy = "id")
    @Getter
    private List<Review> reviews;
}



