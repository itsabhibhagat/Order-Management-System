package com.microservice.order_service.service;

import com.microservice.order_service.entity.Order;

public interface OrderService {

    public Order createOrder(Order order);

    public Order getOrderById(Long id);
}
