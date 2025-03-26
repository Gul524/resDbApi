package com.asadevelopers.resDbApi.controllers;

import com.asadevelopers.resDbApi.authConfigs.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AuthController {

    private final JwtUtil jwtUtil;
    private final String FIXED_USERNAME = "admin";
    private final String FIXED_PASSWORD = "password";

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(Map<String ,String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        if (FIXED_USERNAME.equals(username) && FIXED_PASSWORD.equals(password)) {
            String token = jwtUtil.generateToken("api");
        System.out.println(token);
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
