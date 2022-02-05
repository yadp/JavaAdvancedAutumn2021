package com.example.lecture22.web;

import com.example.lecture22.model.Orders;
import com.example.lecture22.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    public Iterable<Orders> findAll(@RequestParam(required = false,value = "userid") Long userid,
                                    @RequestParam(required = false, value = "bookid") Long bookid){
        if(userid!=null&& bookid!=null){
            return ordersService.findByBookidAndUserid(bookid,userid);
        }
        if(userid!=null){
            return ordersService.findByUserid(userid);
        }
        if(bookid!=null){
            return ordersService.findByBookid(bookid);
        }
        return ordersService.findAll();

    }

    @GetMapping("/{id}")
    public Orders findById(@PathVariable("id") Long id){
        return ordersService.findById(id);
    }


}
