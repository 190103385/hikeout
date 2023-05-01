package com.example.hikeout.domains;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "favorites")
@Builder
public class Favorite {

    @Id
    @SequenceGenerator(name = "favorite_sequence", sequenceName = "favorite_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "favorite_sequence")
    @Column(name = "id")
    @Getter
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Getter
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    @Getter
    private Location location;
}
