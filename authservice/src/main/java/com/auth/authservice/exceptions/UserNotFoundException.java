package com.auth.authservice.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() { super("Usuário não encontrado"); }

    public UserNotFoundException(String message) { super(message); }

    public static UserNotFoundException withEmail(String email) {
        return new UserNotFoundException("Usuário não encontrado com o email: " + email);
    }
}
