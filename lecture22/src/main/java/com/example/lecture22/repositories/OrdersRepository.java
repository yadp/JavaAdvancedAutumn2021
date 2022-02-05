package com.example.lecture22.repositories;

import com.example.lecture22.model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<Orders,Long> {

    Iterable<Orders> findByUserid(Long userid);

    Iterable<Orders> findByBookid(Long bookid);

    Iterable<Orders> findByBookidAndUserid(Long bookid, Long userid);
}
