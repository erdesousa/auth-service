package com.auth.authservice.exceptions;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException() { super("A senha deve ter no mínimo 6 caracteres e é obrigatória"); }
}
