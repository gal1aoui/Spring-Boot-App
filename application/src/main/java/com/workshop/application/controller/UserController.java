package com.workshop.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.application.model.User;
import com.workshop.application.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/connect")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("register")
    public User registerUser(@RequestBody User user) throws Exception {
        
        if(userService.fetchUserByEmail(user.getEmail()) == null){
            throw new Exception("Email already exists");
        }

        return userService.create(user);
    }

    public User loginUser(@RequestBody User user) throws Exception{
        if(userService.fetchUserByEmailAndPassword(user.getEmail(), user.getPassword()) == null){
            throw new Exception("Username or Password are incorrect");
        }

        return user;
    }
}