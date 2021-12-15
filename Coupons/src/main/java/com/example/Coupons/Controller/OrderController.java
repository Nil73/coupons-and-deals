package com.example.Coupons.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Coupons.Model.Order;
import com.example.Coupons.Model.TransactionRequest;
import com.example.Coupons.Model.TransactionResponse;
import com.example.Coupons.Service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/couponOrder")   // Requesting TransactionRequest class and will ask for order object from it
    public TransactionResponse couponOrder(@RequestBody TransactionRequest request){


        return orderService.saveOrder(request);
    }

    @GetMapping(value = "/list")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

}
