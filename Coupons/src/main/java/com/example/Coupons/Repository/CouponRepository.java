package com.example.Coupons.Repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Coupons.Model.Coupon;


public interface  CouponRepository extends MongoRepository<Coupon, String> {


}
