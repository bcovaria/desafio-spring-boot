package com.previred.taskmanager.controller;

import com.previred.taskmanager.dto.LoginRequest;
import com.previred.taskmanager.security.JwtUtil;
import com.previred.taskmanager.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) throws Exception {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        System.out.println("Intento de login con usuario: " + username + " y password: " + password);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        System.out.println("Password en DB: " + userDetails.getPassword());

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        return jwtUtil.generateToken(userDetails.getUsername());
    }

}

