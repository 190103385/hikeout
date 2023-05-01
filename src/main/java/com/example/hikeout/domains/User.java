package com.example.hikeout.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Builder
public class User implements UserDetails {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "user_sequence")
    @Column(name = "id")
    @Getter
    private Long id;

    @Column(name = "email")
    @Setter
    private String email;

    @Column(name = "password")
    @Getter
    private String password;

    @Column(name = "first_name")
    @Getter
    @Setter
    private String firstName;

    @Column(name = "last_name")
    @Getter
    @Setter
    private String lastName;

    @Column(name = "phone")
    @Getter
    @Setter
    private String phone;

    @Column(name = "created_at")
    @Getter
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    @Getter
    @Setter
    private LocalDateTime modifiedAt;

    @Column(name = "is_locked")
    @Getter
    @Setter
    private Boolean isLocked;

    @Column(name = "is_enabled")
    @Getter
    @Setter
    private Boolean isEnabled;

    @Column(name = "role")
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "id")
    @Getter
    @Setter
    @JsonIgnore
    private List<Review> reviews;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "user")
    @Getter
    @Setter
    @JsonIgnore
    private List<Favorite> favorites;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());

        return Collections.singletonList(authority);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
