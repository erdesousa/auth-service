package com.auth.authservice.controllers;

import com.auth.authservice.dto.LoginRequestDTO;
import com.auth.authservice.dto.RegisterRequestDTO;
import com.auth.authservice.dto.RespondeDTO;
import com.auth.authservice.entities.User;
import com.auth.authservice.exceptions.InvalidCredentialsException;
import com.auth.authservice.exceptions.InvalidPasswordException;
import com.auth.authservice.exceptions.UserNotFoundException;
import com.auth.authservice.repositories.UserRepository;
import com.auth.authservice.security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        User user = this.userRepository.findByEmail(body.email())
                .orElseThrow(() -> UserNotFoundException.withEmail(body.email()));

        if (passwordEncoder.matches(body.password(), user.getPassword())){
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.status(200).body(new RespondeDTO(token));
        }

        throw new InvalidCredentialsException();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        Optional<User> user = this.userRepository.findByEmail(body.email());

        if (user.isEmpty()){
            User newUser = new User();
            newUser.setEmail(body.email());
            newUser.setPassword(passwordEncoder.encode(body.password()));
            this.userRepository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.status(201).body(new RespondeDTO(token));
        }
        return ResponseEntity.badRequest().build();
    }
}
