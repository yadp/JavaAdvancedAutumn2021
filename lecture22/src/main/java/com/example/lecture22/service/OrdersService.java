package com.example.lecture22.service;

import com.example.lecture22.model.Book;
import com.example.lecture22.model.Orders;
import com.example.lecture22.model.User;
import com.example.lecture22.repositories.BookRepository;
import com.example.lecture22.repositories.OrdersRepository;
import com.example.lecture22.repositories.UserRepository;
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


    public Orders createOrder(Orders orders){
        //Book exist
        Book book = bookRepository.findById(orders.getBookid()).get();
        //User exist
        User user = userService.findById(orders.getUserid());
        // Order / save
        //orders.setUser(user);
        //orders.setBook(book);

        orders = ordersRepository.save(orders);

        orders.setUser(user);
        orders.setBook(book);
        return orders;
    }



}
