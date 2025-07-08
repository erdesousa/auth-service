package com.auth.authservice.controllers;

import com.auth.authservice.dto.AuthenticatedResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AuthenticatedController {
    @GetMapping
    public ResponseEntity<AuthenticatedResponseDTO> getUser(){
        return ResponseEntity.ok(new AuthenticatedResponseDTO(AuthenticatedResponseDTO.RESPONSE_MESSAGE));
    }
}
