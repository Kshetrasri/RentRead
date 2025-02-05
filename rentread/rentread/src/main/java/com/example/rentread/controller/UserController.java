package com.example.rentread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.rentread.beans.LoginRequest;
import com.example.rentread.entity.User;
import com.example.rentread.service.UserService;

import jakarta.validation.Valid;

@SpringBootApplication
@RequestMapping("/users")
public class UserController {
	
	@Autowired
    UserService userService;
	@Autowired
    AuthenticationManager authenticationManager;

    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully with email: " + registeredUser.getEmail());
    }

  
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok("Login successful!");
        }
        return ResponseEntity.status(401).body("Invalid credentials!");
    }
}

