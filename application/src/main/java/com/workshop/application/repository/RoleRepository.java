package com.workshop.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.application.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
