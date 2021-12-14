package com.example.lecture13.homework;

import java.util.List;

/**
 * Class for a firm. Contains:
 *  Name of the firm
 *  Employees in a list
 */
public class Firm {

    private String name;
    private List<Person> employee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Person> employee) {
        this.employee = employee;
    }
}
