package com.example.demoProject.repositories;

import com.example.demoProject.model.Orders;
import com.example.demoProject.model.User;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders,Long> {

    Iterable<Orders> findByUser(User user);
}
