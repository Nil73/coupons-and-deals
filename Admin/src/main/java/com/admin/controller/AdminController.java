package com.admin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.admin.model.Admin;
import com.admin.model.Coupon;
import com.admin.model.User;
import com.admin.repository.AdminRepository;
import com.admin.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
    @Autowired
    RestTemplate restTemplate;
    
	@Autowired
	public AdminRepository adminRepository;
	
	
	@GetMapping(value = "/all")
	public List<Admin> getAllUsers(){
		return adminRepository.findAll();
	}
	@GetMapping(value = "/name/{name}")
	public Admin getAdmin(@PathVariable("name") String name) {
		return adminRepository.findByName(name);
	}
	
    @PostMapping("/add") // Adding new user
    public String addUser(@RequestBody Admin admin){
        adminRepository.save(admin);
        return "Admin Added Succesfully";
    }
	
    @DeleteMapping("/delete/{id}") // deleting user with specific id
    public String deleteAdmin(@PathVariable String id) {
        adminRepository.deleteById(id);
        return "Admin With Id = "+ id +" Deleted Successfully";
    }
	
    @PutMapping("/update/{id}")// updating details of existing admin  
    public String updateAdmin(@RequestBody Admin admin, @PathVariable String id){
        adminRepository.save(admin);
        return "admin is Updated Succesfully";
		
	}
    
    //------------------- admin-Coupon-----------------------------
    @GetMapping(value = "/listCoupon")
    public List<Coupon> getAllCoupons(){
        return Arrays.asList(restTemplate.getForObject("http://coupon-service/coupons/list",Coupon[].class));
    }

    @PostMapping(value = "/addCoupon")
    public  String addCoupon(@RequestBody Coupon coupon){
        return  restTemplate.postForObject("http://coupon-service/coupons/add",coupon,String.class);
    }

    @DeleteMapping(value = "/delete/{couponID}")
    public String deleteProduct(@PathVariable String couponID) {
    	 restTemplate.delete("http://coupon-service/coupons/delete/{couponID}", couponID, String.class);
        return "Coupon with Id = "+couponID+" Deleted Successfully";
    }
    @PutMapping(value = "/updateCoupon/{couponID}")
    public String updateCoupon(@RequestBody Coupon coupon, @PathVariable String couponID){
        restTemplate.put("http://coupon-service/coupons/update/{couponID}",coupon,couponID,String.class);
        return "coupon Updated Succesfully";
    }
    
  //------------------- admin-User-----------------------------
    
    @GetMapping(value = "/listUsers")
    public List<User> getAllUser(){
        return Arrays.asList(restTemplate.getForObject("http://customer-service/user/list",User[].class));
    }
    @DeleteMapping(value = "/deleteCustomer/{userID}")
    public String deleteUser(@PathVariable String userID) {
        restTemplate.delete("http://customer-service/user/delete/{userID}", userID, String.class);
        return "Customer Deleted Successfully";
    }

    @PutMapping(value = "/updateCustomer/{userID}")
    public String updateUser(@RequestBody User user, @PathVariable String userID){
        restTemplate.put("http://customer-service/user/update/{userID}",user,userID,String.class);
        return "Customer Updated Successfully";
    }
	
}