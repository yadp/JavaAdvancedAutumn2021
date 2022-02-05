package com.example.demoProject.service;

import com.example.demoProject.model.Book;
import com.example.demoProject.model.Orders;
import com.example.demoProject.model.User;
import com.example.demoProject.repositories.BookRepository;
import com.example.demoProject.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    UserService userService;

    @Autowired
    BookRepository bookRepository;


    public Orders createOrder( Orders orders){


        orders = ordersRepository.save(orders);


        return orders;
    }


    public Iterable<Orders> findAll() {
       return ordersRepository.findAll();
    }
}
