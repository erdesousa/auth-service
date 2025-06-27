package com.auth.authservice.exceptions;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException() { super("Endereço de e-mail inválido ou obrigatório"); }
}
