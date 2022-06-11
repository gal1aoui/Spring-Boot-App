package com.application.gallaoui.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.application.gallaoui.application.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE LOWER(u.email)=LOWER(?1) or LOWER(u.username)=LOWER(?1)")
    Optional<User> findByEmailOrUsername(String account);

    @Modifying
    @Query("UPDATE User u SET u.enabled = TRUE WHERE u.email = ?1")
    int enableUser(String email);
}