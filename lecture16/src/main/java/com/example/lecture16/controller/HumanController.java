package com.example.lecture16.controller;

import com.example.lecture16.model.Human;
import com.example.lecture16.repositories.HumanRepository;
import com.example.lecture16.repositories.HumanRowMapper;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class HumanController {

    private final HumanRepository humanRepository;


    public HumanController(HumanRepository humanRepository) {

        this.humanRepository = humanRepository;
    }

    @PostMapping("/human")
    public void createHuman(@RequestBody Human human){
        humanRepository.createHuman(human);
    }

    @GetMapping("/human")
    public List<Human> getAll(@RequestParam(required = false) String name){
        if(name==null) {
            return humanRepository.findAllHumans();
        } else {
            return humanRepository.findByName(name);
        }
    }

    @GetMapping("/humanAll")
    public List<Human> getAllHumans(){
        return humanRepository.findAll();
    }

    @GetMapping("/humanLambda")
    public List<Human> getAllHumansLambda(){
        return humanRepository.findAllLambda();
    }

    @GetMapping("/human/{id}")
    public Human getById(@PathVariable int id){
        return humanRepository.findById(id);
    }

    @GetMapping("/humanName")
    public List<Human> getByName(@RequestParam(required = false) String name ){
        return humanRepository.findByName(name);
    }
}
