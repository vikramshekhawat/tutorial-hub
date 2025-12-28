package com.example.helloworldapi.controller;

import com.example.helloworldapi.dto.AuthResponse;
import com.example.helloworldapi.dto.SignInRequest;
import com.example.helloworldapi.dto.SignUpRequest;
import com.example.helloworldapi.entity.Role;
import com.example.helloworldapi.entity.User;
import com.example.helloworldapi.service.UserService;
import com.example.helloworldapi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest) {
        try {
            User user = new User(
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                signUpRequest.getPassword(),
                signUpRequest.getRole() != null ? signUpRequest.getRole() : Role.USER
            );

            User savedUser = userService.signUp(user);
            String token = jwtUtil.generateToken(savedUser.getUsername(), savedUser.getRole().name());

            AuthResponse response = new AuthResponse(
                token,
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getRole(),
                "User registered successfully"
            );

            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest signInRequest) {
        try {
            Optional<User> userOptional = userService.findByUsername(signInRequest.getUsername());

            if (userOptional.isEmpty()) {
                Map<String, String> error = new HashMap<>();
                error.put("error", "Invalid username or password");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
            }

            User user = userOptional.get();

            if (!userService.validatePassword(signInRequest.getPassword(), user.getPassword())) {
                Map<String, String> error = new HashMap<>();
                error.put("error", "Invalid username or password");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
            }

            String token = jwtUtil.generateToken(user.getUsername(), user.getRole().name());

            AuthResponse response = new AuthResponse(
                token,
                user.getUsername(),
                user.getEmail(),
                user.getRole(),
                "Login successful"
            );

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "An error occurred during sign in");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
}

