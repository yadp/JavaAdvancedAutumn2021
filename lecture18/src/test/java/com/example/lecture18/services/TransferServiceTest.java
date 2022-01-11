package com.example.lecture18.services;

import com.example.lecture18.model.Person;
import com.example.lecture18.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class TransferServiceTest {

    @MockBean
    private PersonRepository personRepository;

    @Test
    void transfer() {
        Person sender= new Person();
        sender.setName("Sender");
        sender.setId(1L);
        sender.setMoney(100);

        when(personRepository.findById(1L)).thenReturn(Optional.of(sender));


        System.out.println((personRepository.findById(1L).get()));
        System.out.println((personRepository.findById(2L).get()));

    }
}