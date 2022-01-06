package com.example.lecture17.services;

import com.example.lecture17.model.Person;
import com.example.lecture17.repositories.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {
    private final PersonRepository personRepository;

    public TransferService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void transfer(Long idSender, Long idReceiver, Double money){
        Person sender= personRepository.findById(idSender).get();
        Person receiver= personRepository.findById(idReceiver).get();
        if(sender.getMoney()<money){
            throw new RuntimeException();
        }
        personRepository.changeMoney(idSender,sender.getMoney()-money);
        personRepository.changeMoney(idReceiver,receiver.getMoney()+money);
    }
}
