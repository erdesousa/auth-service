package com.auth.authservice.exceptions;

public class InvalidEmailAndPasswordException extends RuntimeException {
    public InvalidEmailAndPasswordException() { super("Os campos e-mail e senha são de preenchimento obrigatório"); }
}
