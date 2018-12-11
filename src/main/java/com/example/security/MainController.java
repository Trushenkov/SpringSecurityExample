package com.example.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(value="/home")
    public String getHomePage() {
        return "home";
    }

    @GetMapping(value="/incorrect")
    public String getIncorrectPage() {
        return "incorrect";
    }

}