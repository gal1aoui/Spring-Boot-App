package com.application.gallaoui.application.service.Registration;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationRequest {
    
    private final String name;
    private final String username;
    private final String email;
    private final String password;
}
