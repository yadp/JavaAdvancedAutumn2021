package com.example.lecture22.repositories;

import com.example.lecture22.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
