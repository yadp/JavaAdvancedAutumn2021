package com.example.demoProject.advice;

import com.example.demoProject.exceptions.UserDoesNotExist;
import com.example.demoProject.exceptions.WrongArguments;
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
