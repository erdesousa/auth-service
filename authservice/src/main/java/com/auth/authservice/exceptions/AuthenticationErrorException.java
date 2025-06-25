package com.auth.authservice.exceptions;

public class AuthenticationErrorException extends RuntimeException{

    public AuthenticationErrorException() { super("Erro enquanto estava autenticando"); }

    public AuthenticationErrorException(String message) { super(message); }
}
