package com.HashedInLibraryApplication.userManagement.ExceptionHandling;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalUserExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> handleUserException(UserException userException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userException.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException constraintViolationException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(constraintViolationException.getMessage());
    }
}
