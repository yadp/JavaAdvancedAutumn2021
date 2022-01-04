package com.example.lecture16.controller;

import com.example.lecture16.model.Human;
import com.example.lecture16.repositories.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {

    @Autowired
    private final HumanRepository humanRepository;


    public HumanController(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    @PostMapping("/human")
    public void createHuman(@RequestBody Human human){
        humanRepository.createHuman(human);
    }
}
