package com.auth.authservice.exceptions.handlers;

import com.auth.authservice.exceptions.*;
import com.auth.authservice.exceptions.messages.RestErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<RestErrorMessage> userNotFoundHandler(UserNotFoundException exception) {
        RestErrorMessage jsonErrorResponse = new RestErrorMessage(HttpStatus.NOT_FOUND ,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonErrorResponse);
    }

    @ExceptionHandler(AuthenticationErrorException.class)
    private ResponseEntity<RestErrorMessage> authenticationErrorHandles(AuthenticationErrorException exception){
        RestErrorMessage jsonErrorResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonErrorResponse);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    private ResponseEntity<RestErrorMessage> invalidCredentialsException(InvalidCredentialsException exception){
        RestErrorMessage jsonErrorResponse = new RestErrorMessage(HttpStatus.UNAUTHORIZED, exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(jsonErrorResponse);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<RestErrorMessage> invalidPasswordException(InvalidPasswordException exception) {
        RestErrorMessage jsonErrorResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonErrorResponse);
    }

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<RestErrorMessage> invalidEmailException(InvalidEmailException exception) {
        RestErrorMessage jsonErrorResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonErrorResponse);
    }

    @ExceptionHandler(InvalidEmailAndPasswordException.class)
    public ResponseEntity<RestErrorMessage> invalidEmailAndPasswordException(InvalidEmailAndPasswordException exception) {
        RestErrorMessage jsonErrorResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonErrorResponse);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<RestErrorMessage> emailAlreadyExistsException(EmailAlreadyExistsException exception) {
        RestErrorMessage jsonErrorResponse = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(jsonErrorResponse);
    }
}
