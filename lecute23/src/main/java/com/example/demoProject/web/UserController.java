package com.example.demoProject.web;

import com.example.demoProject.service.UserService;
import com.example.demoProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public Iterable<User> findAll(
            @RequestParam(required = false, value = "name") String name
    ){
        if (name!=null){
            return userService.findByName(name);
        }else {
            return userService.findAll();
        }
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
