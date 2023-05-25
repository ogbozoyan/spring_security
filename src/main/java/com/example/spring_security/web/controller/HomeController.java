package com.example.spring_security.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ogbozoyan
 * @date 25.05.2023
 */
@RestController("/")
public class HomeController {

    @GetMapping
    public String index() {
        return "Index page";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin whatsup";
    }

    @GetMapping("/user")
    public String user() {
        return "user whatsup";
    }
}
