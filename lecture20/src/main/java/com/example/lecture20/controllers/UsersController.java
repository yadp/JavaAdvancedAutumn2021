package com.example.lecture20.controllers;

import com.example.lecture20.model.Authorities;
import com.example.lecture20.model.Users;
import com.example.lecture20.repositories.AuthoritiesRepo;
import com.example.lecture20.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UsersController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthoritiesRepo authoritiesRepo;

    @PostMapping("/user")
    public Users create(@RequestBody Users users){
        users.setEnabled(1);
        Authorities authorities= new Authorities(users.getUsername(),"read");
        users = userRepo.save(users);
        authoritiesRepo.save(authorities);
        return users;
    }
}
