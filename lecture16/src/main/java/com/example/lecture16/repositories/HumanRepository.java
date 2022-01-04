package com.example.lecture16.repositories;

import com.example.lecture16.model.Human;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HumanRepository {

    private final JdbcTemplate jdbc;

    public HumanRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void createHuman(Human human){
        String sql= "INSERT INTO human VALUES (NULL, ?, ?)";
        System.out.println("Trying to write human with id "+ human.getId());
        jdbc.update(sql, human.getName(), human.getAge());
    }

    public List<Human> findAllHumans(){
        String sql = "SELECT * FROM HUMAN";

        List<Human> humans= jdbc.query(sql,new HumanRowMapper());
        return humans;
    }

    public List<Human> findAll(){
        String sql = "SELECT * FROM HUMAN";
        List<Human> humans= jdbc.query(sql, new BeanPropertyRowMapper(Human.class));
        return humans;
    }

    public List<Human> findAllLambda(){
        String sql = "SELECT * FROM HUMAN";
        List<Human> humans= jdbc.query(sql,
                (rs, rowNum) -> new Human(
                        rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getInt("AGE")
                ));
        return humans;
    }

    public Human findById(int id){
        String sql = "Select * from HUMAN where id=?";
        return jdbc.queryForObject(
                sql,
                new Object[]{id},
                new BeanPropertyRowMapper<>(Human.class)
        );
    }

    /*
    Create find by name method
     */



}
