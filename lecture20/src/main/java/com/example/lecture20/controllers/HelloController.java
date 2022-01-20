package com.example.lecture20.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/testAdmin")
    public String testAdmin(){
        return "Test Admin";
    }
}
