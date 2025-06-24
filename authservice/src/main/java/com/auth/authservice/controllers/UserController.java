package com.auth.authservice.controllers;

import com.auth.authservice.dto.LoginRequestDTO;
import com.auth.authservice.dto.RespondeDTO;
import com.auth.authservice.entities.User;
import com.auth.authservice.repositories.UserRepository;
import com.auth.authservice.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        User user = this.userRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if (passwordEncoder.matches(user.getPassword(), body.password())){
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new RespondeDTO(user.getEmail(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
