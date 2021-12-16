package com.example.Lecture14.controllers;


import com.example.Lecture14.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {

    private List<Person> personList;

    public PersonController(){
        personList= new
                ArrayList<>();
        Person yavor= new
                Person();
        yavor.setName("Yavor");
        personList.add(yavor);
    }

    @GetMapping("/person")
    public String viewPerson(Model page){
        page.addAttribute("persons",personList);
        page.addAttribute("color","blue");
        for (Person selectedPerson:personList){
            System.out.println(selectedPerson.getName());
        }
        return "person.html";
    }

    @PostMapping("/person")
    public String addPerson(Person postPerson,Model page){
        personList.add(postPerson);
        page.addAttribute("persons",personList);
        return "person.html";
    }


}
