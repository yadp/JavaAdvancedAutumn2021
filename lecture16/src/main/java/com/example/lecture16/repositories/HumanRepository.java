package com.example.lecture16.repositories;

import com.example.lecture16.model.Human;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HumanRepository {

    private final JdbcTemplate jdbc;

    public HumanRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void createHuman(Human human){
        String sql= "INSERT INTO human VALUES (NULL, ?)";
        System.out.println("Trying to write human with id "+ human.getId());
        jdbc.update(sql, human.getName());
    }
}
