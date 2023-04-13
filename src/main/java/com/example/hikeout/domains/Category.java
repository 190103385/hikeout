package com.example.hikeout.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Category")
@Table(name = "categories")
@Builder
public class Category {

    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "category_sequence"
    )
    @Column(name = "id")
    @Getter
    private Long id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "icon")
    @Getter
    @Setter
    private String icon;

    @OneToMany(mappedBy = "id")
    @Getter
    @Setter
    @JsonIgnoreProperties({"category", "priceItems", "favorite", "reviews"})
    private List<Location> locations;

}
