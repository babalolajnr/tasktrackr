package com.tasktrackr.tasktrackr.auth.user.v1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasktrackr.tasktrackr.auth.user.UserAuthService;
import com.tasktrackr.tasktrackr.auth.user.v1.dto.LoginRequest;
import com.tasktrackr.tasktrackr.auth.user.v1.dto.RegisterRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserAuthService userAuthService;

    public AuthController(AuthenticationManager authenticationManager, UserAuthService userAuthService) {
        this.authenticationManager = authenticationManager;
        this.userAuthService = userAuthService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok("User authenticated");
        }

        return ResponseEntity.badRequest().body("Invalid credentials");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest) {
        userAuthService.registerUser(registerRequest);

        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully");
        response.put("data", null);
        return ResponseEntity.ok(response);
    }
}