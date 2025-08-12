package com.HashedInLibraryApplication.LibrarianBookManagement.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalBookExceptionHandler {

    @ExceptionHandler(BookException.class)
    public ResponseEntity<String> handleBookException(BookException bookException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bookException.getMessage());
    }
}
