package com.example.hikeout.repositories;

import com.example.hikeout.domains.User;
import com.example.hikeout.domains.UserRole;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findAllByOrderById();

    Optional<User> findUserById(Long id);

    List<User> findUserByRoleEquals(UserRole role);

    @Transactional
    void deleteUserById(Long id);
}
