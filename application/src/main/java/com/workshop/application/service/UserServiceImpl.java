package com.workshop.application.service;

import org.springframework.stereotype.Service;

import com.workshop.application.model.User;
import com.workshop.application.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
  
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }  
}
