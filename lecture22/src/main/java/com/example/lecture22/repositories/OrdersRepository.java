package com.example.lecture22.repositories;

import com.example.lecture22.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders,Long> {
}
