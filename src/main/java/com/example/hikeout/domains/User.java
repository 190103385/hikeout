package com.example.hikeout.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "id")
    @Getter
    private Long id;

    @Column(name = "email")
    @Getter
    private String email;

    @Column(name = "password")
    @Getter
    private String password;

    @Column(name = "first_name")
    @Getter
    private String firstName;

    @Column(name = "last_name")
    @Getter
    private String lastName;

    @Column(name = "phone")
    @Getter
    private String phone;

    @Column(name = "created_at")
    @Getter
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    @Getter
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "id")
    @Getter
    private List<Review> reviews;

    @OneToMany(mappedBy = "id")
    @Getter
    private List<Favorite> favorites;
}
