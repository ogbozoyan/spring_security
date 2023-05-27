package com.example.spring_security.web.controller;

import com.example.spring_security.configuration.jwt.JwtUtil;
import com.example.spring_security.service.MyUserDetailsService;
import com.example.spring_security.web.dto.AuthRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ogbozoyan
 * @date 27.05.2023
 */
@RestController("/authenticate")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public void register() {

    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequestDTO authRequestDTO) {
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                            authRequestDTO.getUsername(),
                            authRequestDTO.getPassword()
                    )
            );

            final UserDetails user = userDetailsService.loadUserByUsername(authRequestDTO.getUsername());

            return jwtUtil.generateToken(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
