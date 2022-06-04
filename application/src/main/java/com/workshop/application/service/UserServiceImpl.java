package com.workshop.application.service;

import org.springframework.stereotype.Service;

import com.workshop.application.model.User;
import com.workshop.application.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
  
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }  
}
