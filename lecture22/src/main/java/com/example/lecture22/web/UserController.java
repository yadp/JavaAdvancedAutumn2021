package com.example.lecture22.web;

import com.example.lecture22.model.User;
import com.example.lecture22.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public Iterable<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @PostMapping("/")
    public User save(@RequestBody  User user){
        return userService.save(user);
    }
}
