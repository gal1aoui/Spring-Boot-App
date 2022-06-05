package com.workshop.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.application.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}
