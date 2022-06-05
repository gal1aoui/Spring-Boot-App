package com.workshop.application.service;

import java.util.Date;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.workshop.application.model.Role;
import com.workshop.application.model.User;
import com.workshop.application.repository.RoleRepository;
import com.workshop.application.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{
  
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Override
    public User create(User user) {
        Role roleUser = roleRepository.findById(1L).get();
        user.setCreatedAt(new Date());
        user.setPicture(ServletUriComponentsBuilder.fromCurrentContextPath().path("images/User_Avatar.png").toUriString());
        user.setIsVerified(false);
        user.addRole(roleUser);
        return userRepository.save(user);
    }

    @Override
    public Set<User> list(int limit) {
        return userRepository.findAll(PageRequest.of(0, limit)).toSet();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    public User fetchUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User fetchUserByEmailAndPassword(String email, String password){
        return userRepository.findByEmailAndPassword(email, password);
    }

}
