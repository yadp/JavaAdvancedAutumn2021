package com.example.Lecture15.controllers;

import com.example.Lecture15.exception.StudentNotExistingException;
import com.example.Lecture15.model.ErrorDetails;
import com.example.Lecture15.model.Student;
import com.example.Lecture15.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    public ResponseEntity<List<Student>> listAll(){
        return ResponseEntity
                .status(200)
                .header("ExampleHeader","Yavor")
                .body(studentService.findAll());

    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student>  getStudent(@PathVariable int id){
        return ResponseEntity.ok().body(studentService.findById(id));

    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        student = studentService.addStudent(student);
        return student;
    }

}
