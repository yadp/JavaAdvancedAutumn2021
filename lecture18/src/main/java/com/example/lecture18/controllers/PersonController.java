package com.example.lecture18.controllers;


import com.example.lecture18.model.Person;
import com.example.lecture18.repositories.PersonRepository;
import com.example.lecture18.services.TransferService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private final PersonRepository personRepository;
    private final TransferService transferService;

    public PersonController(PersonRepository personRepository, TransferService transferService) {
        this.personRepository = personRepository;
        this.transferService = transferService;
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

    @GetMapping("/person/age")
    public Iterable<Person> listPersonOver(@RequestParam(required = false) Integer over,
                                           @RequestParam(required = false) Integer under){

        if (over!=0) {
            return personRepository.findByAgeGreaterThan(over);
        }
        return null;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestParam Long idSender,
                              @RequestParam Long idReceiver,
                              @RequestParam Double money){
        transferService.transfer(idSender,idReceiver,money);
    }

    @PutMapping("/person/{id}")
    public void updateMoney( @PathVariable() Long id, @RequestParam(required = true) Double money){
        personRepository.changeMoney(id,money);
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
