package com.example.lecture17.controllers;


import com.example.lecture17.model.Person;
import com.example.lecture17.repositories.PersonRepository;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person){
        person.setId(null);
        return personRepository.save(person);
    }

    @GetMapping("/person")
    public Iterable<Person> listAll(@RequestParam(required = false) String name){
        if (name!=null){
            return personRepository.findByName(name);
        }
        return personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public Person getId(@PathVariable Long id){
        return personRepository.findById(id).get();
    }

    @DeleteMapping("/person/{id}")
    public void deleteById(@PathVariable Long id){
        personRepository.deleteById(id);
    }



}
