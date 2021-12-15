package com.example.Coupons.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.Coupons.Model.Coupon;
import com.example.Coupons.Service.CouponService;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponController {
	
	  private final CouponService couponService;

	    @Autowired
	    public CouponController(CouponService couponService) {
	        this.couponService = couponService;
	    }

    @GetMapping(value = "/list")
    public List<Coupon> getAllCoupons(){
        return couponService.getAllCoupons();
    }

    @PostMapping(value = "/add")
    public String addCoupon(@RequestBody Coupon coupon){
    	couponService.addCoupon(coupon);
        return "Coupon Added Successfully";
    }

    @DeleteMapping(value = "/delete/{couponID}")
    public String deleteProduct(@PathVariable String couponID) {
    	couponService.deleteCoupon(couponID);
        return "Coupon Deleted Successfully";
    }

    @PutMapping(value = "/update/{couponID}")
    public Coupon updateCoupon(@RequestBody Coupon coupon, @PathVariable String couponID){
        return couponService.updateCoupon(coupon, couponID);

    }
}
