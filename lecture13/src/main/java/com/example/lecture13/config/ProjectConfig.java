package com.example.lecture13.config;


import com.example.lecture13.person.Person;
import com.example.lecture13.person.Student;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

//@Configuration
@ComponentScan(basePackages = "person")
public class ProjectConfig {

    @Bean("Ben")
    @Order(1)
    Person ben(){
        Person ben=new Person();
        ben.setName("ben");
        return ben;
    }

    @Bean("Jack")
    @Order(2)
    @DependsOn("Ben")
    Person jack(){
        Person jack=new Person();
        jack.setName("jack");
        return jack;
    }

    @Bean
    String name(){
        return "Yavor";
    }

    /*@Bean
    Student student(){
        Student student= new Student();
        Person testPerson= new Person();
        testPerson.setName("Test");
        student.setPerson(jack());
        return student;
    }*/
}
