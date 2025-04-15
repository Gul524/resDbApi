package com.asadevelopers.resDbApi.controllers;

import com.asadevelopers.resDbApi.Constraints;
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
    public ResponseEntity<?> login(@RequestBody Map<String ,String> credentials) {


        String username = credentials.get("username");
        String password = credentials.get("password");

        if (Constraints.apiUsername.equals(username) && Constraints.apiPassword.equals(password)) {
            String token = jwtUtil.generateToken(Constraints.apiUsername);
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
