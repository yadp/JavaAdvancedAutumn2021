package com.example.lecture22.web;

import com.example.lecture22.model.Orders;
import com.example.lecture22.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @PostMapping("/")
    public Orders createOrders(@RequestBody Orders orders){
        return ordersService.createOrder(orders);
    }
}
