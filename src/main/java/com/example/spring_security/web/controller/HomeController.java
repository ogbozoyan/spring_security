package com.example.spring_security.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ogbozoyan
 * @date 25.05.2023
 */
@RestController("/")
public class HomeController {

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String index() {
        return "Index page";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "admin whatsup";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/user")
    public String user() {
        return "user whatsup";
    }

    @GetMapping("/me")
    public Object me() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
