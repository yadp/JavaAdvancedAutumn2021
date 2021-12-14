package com.example.lecture13.homework;

/**
 * Class that represents employees in a firm. Contains:
 *  Name of the Employee
 *  Salary of the Employee
 */
public class Person {
    private String name;
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
