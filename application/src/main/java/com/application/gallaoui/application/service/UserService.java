package com.application.gallaoui.application.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.application.gallaoui.application.model.User;
import com.application.gallaoui.application.repository.UserRepository;
import com.application.gallaoui.application.service.Registration.Token.ConfirmationToken;
import com.application.gallaoui.application.service.Registration.Token.ConfirmationTokenService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        return userRepository.findByEmailOrUsername(account)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("%s User haven't registred yet", account)));
    }
    
    public String signUpUser(User user) {
       Boolean userWithEmailExist = userRepository.findByEmailOrUsername(user.getEmail()).isPresent();
       Boolean userWithUsernameExist = userRepository.findByEmailOrUsername(user.getUsername()).isPresent();

       if(userWithEmailExist || userWithUsernameExist) throw new IllegalStateException(String.format("User with %s already registred", user.getEmail()));
       
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       user.setPicture(ServletUriComponentsBuilder.fromCurrentContextPath().path("images/User_Avatar.png").toUriString());
       user.setCreatedAt(new Date()); 

       userRepository.save(user);

       String token = UUID.randomUUID().toString();
       ConfirmationToken confirmationToken = new ConfirmationToken(
                                                                    token,
                                                                    LocalDateTime.now(),
                                                                    LocalDateTime.now().plusMinutes(30),
                                                                    user   
                                                                  );

        confirmationTokenService.saveToken(confirmationToken);

        return token;
    }

    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }
}