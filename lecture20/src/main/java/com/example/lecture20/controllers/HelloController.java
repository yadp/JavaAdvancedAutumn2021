package com.example.lecture20.controllers;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/hello/{user}")
    public String helloUser(@PathParam("user") String user){
        return "Hello "+ user;
    }

    @GetMapping("/testAdmin")
    public String testAdmin(){
        return "Test Admin";
    }
}
