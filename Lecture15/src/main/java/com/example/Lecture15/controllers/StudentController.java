package com.example.Lecture15.controllers;

import com.example.Lecture15.model.Student;
import com.example.Lecture15.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    public List<Student> listAll(){
        return studentService.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.findById(id);
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        student = studentService.addStudent(student);
        return student;
    }

}
