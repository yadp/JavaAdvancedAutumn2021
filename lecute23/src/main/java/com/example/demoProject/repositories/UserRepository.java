package com.example.demoProject.repositories;

import com.example.demoProject.model.Book;
import com.example.demoProject.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    Iterable<User> findByName(String name);

}
