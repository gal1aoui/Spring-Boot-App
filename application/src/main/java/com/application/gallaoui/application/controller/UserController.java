package com.application.gallaoui.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.gallaoui.application.service.Registration.RegistrationRequest;
import com.application.gallaoui.application.service.Registration.RegistrationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/connect")
@AllArgsConstructor
public class UserController {
       private RegistrationService registrationService;

    @GetMapping("/register/confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }
    
    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest req){
        return registrationService.register(req);
    }
}
