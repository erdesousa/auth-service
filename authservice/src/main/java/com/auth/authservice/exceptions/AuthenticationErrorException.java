package com.auth.authservice.exceptions;

import com.auth0.jwt.exceptions.JWTCreationException;

public class AuthenticationErrorException extends RuntimeException{

    public AuthenticationErrorException(JWTCreationException exception) {
        super("Erro enquanto estava autenticando " + exception.getMessage());
    }
}
