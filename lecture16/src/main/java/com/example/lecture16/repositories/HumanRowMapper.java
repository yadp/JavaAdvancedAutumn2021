package com.example.lecture16.repositories;

import com.example.lecture16.model.Human;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HumanRowMapper implements RowMapper<Human> {
    @Override
    public Human mapRow(ResultSet rs, int rowNum) throws SQLException {
        Human human = new Human();
        human.setId(rs.getInt("ID"));
        human.setName(rs.getString("NAME"));
        human.setAge(rs.getInt("AGE"));
        return human;
    }
}
