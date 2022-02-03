package com.example.lecture22.web;

import com.example.lecture22.model.Orders;
import com.example.lecture22.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @PostMapping("/")
    public Orders createOrders(@RequestBody Orders orders){
        return ordersService.createOrder(orders);
    }

    @GetMapping("/")
    public Iterable<Orders> findAll(){
        return ordersService.findAll();
    }

    @GetMapping("/{id}")
    public Orders findById(@PathVariable("id") Long id){
        return ordersService.findById(id);
    }

    @GetMapping("/{userid}")
    public Iterable<Orders> findByUserid(@PathVariable("userid") Long userid){
        return ordersService.findByUserid(userid);
    }
}
