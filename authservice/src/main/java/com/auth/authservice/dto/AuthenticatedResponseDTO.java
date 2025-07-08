package com.auth.authservice.dto;

public record AuthenticatedResponseDTO(String message) {
    public static final String RESPONSE_MESSAGE = "Autenticado";
}
