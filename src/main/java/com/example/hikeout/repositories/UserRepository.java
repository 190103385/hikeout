package com.example.hikeout.repositories;

import com.example.hikeout.domains.User;
import com.example.hikeout.domains.UserRole;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository to fetch and delete users.
 * */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds user by email.
     * */
    Optional<User> findByEmail(String email);

    /**
     * Finds all users by email and role.
     * */
    List<User> findAllByEmailContainsIgnoreCaseAndRoleEqualsOrderById(String username, UserRole role);

    /**
     * Finds user by ID.
     * */
    Optional<User> findUserById(Long id);

    /**
     * Finds all users by role.
     * */
    List<User> findUserByRoleEqualsOrderById(UserRole role);

    /**
     * Delete user by ID.
     * */
    @Transactional
    void deleteUserById(Long id);
}
