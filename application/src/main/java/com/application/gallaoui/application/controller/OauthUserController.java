package com.application.gallaoui.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/connect")
public class OauthUserController {
    
    @GetMapping()
    public String OauthConnect(){
        return "Connect";
    }
}
