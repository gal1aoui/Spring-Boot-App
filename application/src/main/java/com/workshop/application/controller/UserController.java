package com.workshop.application.controller;


import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.workshop.application.model.User;
import com.workshop.application.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/connect")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping()
    public String showRegister(User user) {
        return "registration-login";
    }

    @GetMapping("/home")
    public String welcome(){
        return "home";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result, Model model) {
        
        if(result.hasErrors()){
            return "registration-login";
        }

        userService.create(user);

        return "redirect:/home";
    }

    
}