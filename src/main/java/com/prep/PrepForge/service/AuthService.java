package com.prep.PrepForge.service;

import com.prep.PrepForge.dto.LoginRequest;
import com.prep.PrepForge.dto.RegisterRequest;
import com.prep.PrepForge.entity.User;
import com.prep.PrepForge.repository.UserRepository;
import com.prep.PrepForge.config.JwtUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository repo,
                       PasswordEncoder encoder,
                       JwtUtil jwtUtil) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    public String register(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole("USER");
        repo.save(user);
        return jwtUtil.generateToken(user.getEmail());
    }

    public String login(LoginRequest request) {
        User user = repo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}
