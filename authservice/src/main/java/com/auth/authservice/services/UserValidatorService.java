package com.auth.authservice.services;

import com.auth.authservice.dto.RegisterRequestDTO;
import com.auth.authservice.exceptions.InvalidEmailException;
import com.auth.authservice.exceptions.InvalidEmailAndPasswordException;
import com.auth.authservice.exceptions.InvalidPasswordException;

public class UserValidatorService {

    public class constants {
        public static final int MIN_PASSWORD_LENGTH = 6;
    }

    public static void validateRegisterData(RegisterRequestDTO dto) {
        validateEmailAndPassword(dto.email(), dto.password());
        validateEmail(dto.email());
        validatePassword(dto.password());
    }

    private static void validateEmail(String email) {
        if (email == null || !email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new InvalidEmailException();
        }
    }

    private static void validatePassword(String password) {
        if (password == null || password.length() < constants.MIN_PASSWORD_LENGTH) {
            throw new InvalidPasswordException();
        }
    }

    private static void validateEmailAndPassword(String email, String password) {
        if ((email == null || email.isBlank()) && (password == null || password.isBlank())) {
            throw new InvalidEmailAndPasswordException();
        }
    }
}
