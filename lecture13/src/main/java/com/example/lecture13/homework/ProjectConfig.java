package com.example.lecture13.homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


/**
 * Configuration of the homework with Employee and Firm beans
 */
@Configuration
public class ProjectConfig {

    /**
     * Create Ben person bean
     * @return the bean
     */
    @Bean("Ben")
    Person getBen(){
        Person ben= new Person();
        ben.setName("Ben");
        ben.setSalary(100);
        return ben;
    }

    /**
     * Create Jack person bean
     * @return the bean
     */
    @Bean("Jack")
    Person getJack(){
        Person jack = new Person();
        jack.setName("Jack");
        jack.setSalary(200);
        return jack;
    }


    /**
     * Creates firm bean with the employees for the other beans
     * @return the bean
     */
    @Bean("ExampleFirm")
    Firm getFirm(){
        Firm firm = new Firm();
        firm.setName("Example Firm");
        List employee= new ArrayList();
        employee.add(getBen());
        employee.add(getJack());
        firm.setEmployee(employee);
        return firm;
    }

}
