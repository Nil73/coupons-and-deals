package com.example.Coupons.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Coupons.Model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

}
