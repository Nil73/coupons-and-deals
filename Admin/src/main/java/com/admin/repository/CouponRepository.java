package com.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.admin.model.Coupon;

public interface CouponRepository extends MongoRepository<Coupon, String> {

}
