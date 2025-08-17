package com.system.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Thymeleaf template named login.html
    }

//    @GetMapping("/welcome")
//    public String welcomePage() {
//        return "welcome"; // Thymeleaf template named welcome.html
//    }
}
