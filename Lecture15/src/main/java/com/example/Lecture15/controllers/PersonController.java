package com.example.Lecture15.controllers;


import com.example.Lecture15.model.Person;
import com.example.Lecture15.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    public PersonController(){

    }

    @GetMapping("/person")
    public List<Person> viewPerson(Model page){
        page.addAttribute("persons",personService.findAll());
        page.addAttribute("color","blue");
        for (Person selectedPerson:personService.findAll()){
            System.out.println(selectedPerson.getName());
        }
        return personService.findAll();
    }

    @PostMapping("/person")
    public Person addPerson(Person postPerson,Model page){
        personService.addPerson(postPerson);
        page.addAttribute("persons",personService.findAll());
        return postPerson;
    }


}
