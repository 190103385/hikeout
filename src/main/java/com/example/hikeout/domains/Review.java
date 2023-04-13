package com.example.hikeout.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
@Builder
public class Review {

    @Id
    @SequenceGenerator(
            name = "review_sequence",
            sequenceName = "review_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "review_sequence"
    )
    @Column(name = "id")
    @Getter
    private Long id;

    @Column(name = "rate")
    @Getter
    @Setter
    private int rating;

    @Column(name = "review")
    @Getter
    @Setter
    private String content;

    @Column(name = "date")
    @Getter
    private LocalDateTime date;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @Getter
    @JsonIgnoreProperties({"category", "priceItems", "favorite", "reviews"})
    private Location location;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Getter
    private User user;
}
