package com.example.Lecture14.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@Controller
public class MainController {

    @GetMapping("/home")
    public String home(){
        return "home.html";
    }



    @GetMapping("/name")
    public String name(Model page){
        page.addAttribute("username","Yavor");
        return "name.html";
    }

    @GetMapping("/name/{nameParam}")
    public String namePath(Model page, @PathVariable String nameParam){
        page.addAttribute("username",nameParam);
        return "name.html";
    }

    @GetMapping("/nameparam")
    public String nameParam(
            Model page,
            @RequestParam String name
    ){
        page.addAttribute("username",name);
        return "name.html";
    }

    // Create application with the same param name property
    // add second param Family name
}
