package com.example.demoProject.web;

import com.example.demoProject.service.OrdersService;
import com.example.demoProject.model.Orders;
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
}
