package com.example.hikeout.services.impl;

import com.example.hikeout.domains.User;
import com.example.hikeout.domains.UserRole;
import com.example.hikeout.dto.UserDto;
import com.example.hikeout.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findUserByRoleEqualsOrderById(UserRole.USER);
    }

    public List<User> getUsersByUsername(String username, UserRole role) {
        return userRepository.findAllByEmailContainsIgnoreCaseAndRoleEqualsOrderById(username, role);
    }

    public List<User> getAllModerators() {
        return userRepository.findUserByRoleEqualsOrderById(UserRole.ADMIN);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", email))
        );
    }

    public UserDetails getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findUserById(id);

        if(optionalUser.isEmpty()) {
            throw new EntityNotFoundException("No such user");
        }

        return optionalUser.get();
    }

    public User getCurrentlyLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) throw new UsernameNotFoundException("User not found");

        User user = null;
        Object principal = authentication.getPrincipal();

        if(principal instanceof UserDetails) {
            user = (User) principal;
        }

        return user;
    }

    public void editUser(UserDto request) {
        User user = (User) getUserById(request.getId());

        if(user != null) {
            user.setEmail(request.getEmail());
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setPhone(request.getPhone());
            user.setModifiedAt(LocalDateTime.now());

            userRepository.save(user);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);
    }

    public void blockUser(Long id) {
        User user = userRepository.findUserById(id).orElseThrow();

        user.setIsEnabled(false);
        user.setIsLocked(true);

        userRepository.save(user);
    }

    public void unblockUser(Long id) {
        User user = userRepository.findUserById(id).orElseThrow();

        user.setIsEnabled(true);
        user.setIsLocked(false);

        userRepository.save(user);
    }

    public void makeAdmin(Long id) {
        User user = userRepository.findUserById(id).orElseThrow();

        user.setRole(UserRole.ADMIN);

        userRepository.save(user);
    }

    public void deleteAdmin(Long id) {
        User user = userRepository.findUserById(id).orElseThrow();

        user.setRole(UserRole.USER);

        userRepository.save(user);
    }
}
