package com.example.seminar7hw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login-page";
    }

    @GetMapping("/public")
    public String publicPage() {
        return "public-data";
    }

    @GetMapping("/private")
    public String privatePage() {
        return "private-data";
    }
}
