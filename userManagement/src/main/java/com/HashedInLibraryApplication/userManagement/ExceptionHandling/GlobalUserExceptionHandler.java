package com.HashedInLibraryApplication.userManagement.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalUserExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> handleUserException(UserException userException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userException.getMessage());
    }
}
