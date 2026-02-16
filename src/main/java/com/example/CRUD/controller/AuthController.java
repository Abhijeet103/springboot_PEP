package com.example.CRUD.controller;


import com.example.CRUD.auth.JwtUtil;
import com.example.CRUD.dto.LoginRequestDto;
import com.example.CRUD.entity.User;
import com.example.CRUD.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    UserRepository userRepository;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto request) {

        // Normally validate from DB
        User user  = userRepository.findByUsername(request.getUsername());
        if (user.getPassword().equals(request.getPassword())) {

            String token = jwtUtil.generateToken(
                    request.getUsername(),
                    "USER"
            );

            return ResponseEntity.ok(token);
        }

        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
