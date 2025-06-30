package com.auth.authservice.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException() { super("O email já está em uso"); }
}
