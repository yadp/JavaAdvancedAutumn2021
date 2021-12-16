package com.example.Lecture15.controllers.advice;

import com.example.Lecture15.exception.StudentNotExistingException;
import com.example.Lecture15.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(StudentNotExistingException.class)
    public ResponseEntity<ErrorDetails> exceptionForStudentNotExisting(){
        ErrorDetails errorDetails= new ErrorDetails();
        errorDetails.setMessage("We don't have this student");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
