package com.example.lecture17.repositories;

import com.example.lecture17.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {

    // SELECT * FROM Person WHERE NAME=?
    List<Person> findByName(String name);
}
