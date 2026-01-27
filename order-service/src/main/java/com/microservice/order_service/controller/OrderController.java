package com.microservice.order_service.controller;

import com.microservice.order_service.entity.Order;
import com.microservice.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order){
        Order orders = orderService.createOrder(order);
        return new ResponseEntity<>(orders, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        Order order = orderService.getOrderById(id);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

}
