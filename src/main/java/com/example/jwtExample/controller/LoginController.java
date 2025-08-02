package com.example.jwtExample.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "loginPage"; // resolves to loginpage.html in templates/
    }

    @GetMapping("/home")
    public String homePage() {
        return "home"; // resolves to home.html in templates/
    }

    @GetMapping("/error")
    public String errorPage() {
        return "error"; // resolves to home.html in templates/
    }
}
