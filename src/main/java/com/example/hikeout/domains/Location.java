package com.example.hikeout.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "locations")
public class Location {

    @Id
    @SequenceGenerator(name = "location_sequence", sequenceName = "location_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "location_sequence")
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "description")
    @Getter
    @Setter
    private String description;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    @Getter
    @Setter
    @JsonIgnoreProperties(value = "locations")
    private Category category;

    @Column(name = "icon")
    @Getter
    @Setter
    private String icon;

    @Column(name = "works_from")
    @Getter
    @Setter
    private String worksFrom;

    @Column(name = "works_till")
    @Getter
    @Setter
    private String worksTill;

    @Column(name = "is_active")
    @Getter
    private Boolean isActive;

    @Column(name = "latitude")
    @Getter
    @Setter
    private Double lat;

    @Column(name = "longitude")
    @Getter
    @Setter
    private Double lon;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    @Getter
    @JsonIgnoreProperties("location")
    private List<PriceItem> priceItems;

    @OneToOne(mappedBy = "location", cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @Getter
    @JsonIgnoreProperties("locations")
    private Favorite favorite;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    @Getter
    @JsonIgnoreProperties({"user", "location"})
    private List<Review> reviews;
}



