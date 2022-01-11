package com.example.lecture18.repositories;

import com.example.lecture18.model.Person;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {

    // SELECT * FROM Person WHERE NAME=?

    @Query("SELECT * FROM Person WHERE name = :name")
    List<Person> findByName(String name);

    List<Person> findByAgeGreaterThan(int age);

    @Modifying
    @Query("UPDATE Person SET money = :money WHERE id = :id")
    void changeMoney( Long id, double money);
 }
