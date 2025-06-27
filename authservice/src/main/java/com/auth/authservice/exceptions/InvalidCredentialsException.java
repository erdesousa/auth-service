package com.auth.authservice.exceptions;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(){ super("Credenciais inválidas"); }
}
