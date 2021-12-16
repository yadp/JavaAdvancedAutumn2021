package com.example.Lecture15.service;

import com.example.Lecture15.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private List<Person> personList;

    PersonService(){
        personList= new
                ArrayList<>();
        Person yavor= new
                Person();
        yavor.setName("Yavor");
        personList.add(yavor);
    }

    public List<Person> findAll(){
        return personList;
    }

    public Person addPerson(Person personToAdd){
        for (Person searchPerson:personList){
            if(personToAdd.getName().equals(searchPerson.getName())){
                return searchPerson;
            }
        }
        personList.add(personToAdd);
        return personToAdd;
    }

}
