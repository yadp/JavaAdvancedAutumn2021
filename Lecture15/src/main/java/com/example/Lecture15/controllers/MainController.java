package com.example.Lecture15.controllers;

import com.example.Lecture15.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    PersonService personService;

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
            @RequestParam String name,
            @RequestParam String secondName
    ){
        page.addAttribute("username",name);
        page.addAttribute("secondName",secondName);
        return "name.html";
    }

    @GetMapping("/listNames")
    public String listNames(Model page){
        List<String> names= new ArrayList<>();
        names.add("Yavor");
        names.add("Ted");
        page.addAttribute("listNames", names);
        return "listNames.html";
    }

    // Create application with the same param name property
    // add second param Family name
}
