package com.example.lecture22.advice;

import com.example.lecture22.exception.UserDoesNotExist;
import com.example.lecture22.exception.WrongArguments;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(WrongArguments.class)
    public ResponseEntity<String> exceptionWrongArguments(){
        return ResponseEntity
                .badRequest()
                .body("This is body message of the wrong arguments exception");
    }

    @ExceptionHandler(UserDoesNotExist.class)
    public ResponseEntity<String> exceptionUserDoesNotExist(){
        return ResponseEntity
                .badRequest()
                .body("This is body message of the UserDoesNotExist exception");
    }
}
