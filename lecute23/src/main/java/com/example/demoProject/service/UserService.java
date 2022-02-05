package com.example.demoProject.service;

import com.example.demoProject.exceptions.WrongArguments;
import com.example.demoProject.exceptions.UserDoesNotExist;
import com.example.demoProject.model.User;
import com.example.demoProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> findByName(String name){
        return userRepository.findByName(name);
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    /**
     * Check for user with this id and if not found returns an error
     * @param id of the user
     * @return User object that we found
     */
    public User findById(Long id){
        if(id.equals(null) || id <= 0L ){
            throw new WrongArguments();
        } else {
            Optional<User> foundUser = userRepository.findById(id);
            if(foundUser.isPresent()){
                return foundUser.get();
            }else {
                throw new UserDoesNotExist();
            }
        }
    }

    /**
     * Saves user in the DB. Checks all properties for null or blank values
     * @param user object that we want to save
     * @return object with id from DB
     */
    public User save(User user){
        if(user.getName() == null || user.getName().isBlank()){
            throw new WrongArguments();
        }
        if(user.getAddress() == null || user.getAddress().isBlank()){
            throw new WrongArguments();
        }
        return userRepository.save(user);
    }
}
