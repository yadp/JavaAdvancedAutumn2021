package com.example.lecture20.repositories;

import com.example.lecture20.model.Authorities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepo extends CrudRepository<Authorities,Long> {
}
