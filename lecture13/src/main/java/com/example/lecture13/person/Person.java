package com.example.lecture13.person;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * Create Spring Project
 * Create Person Class with name
 * Create Bean from this class ( with @Component)
 * Create Second Bean from this class with @Bean Annotation
 * Which one is the prime Bean
 */
