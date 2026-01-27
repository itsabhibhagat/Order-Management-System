package com.microservice.order_service.service;

import com.microservice.order_service.entity.Order;
import com.microservice.order_service.exceptions.InsufficientException;
import com.microservice.order_service.exceptions.ResourceNotFoundException;
import com.microservice.order_service.feignClient.InventoryFeign;
import com.microservice.order_service.feignClient.ProductFeign;
import com.microservice.order_service.repository.OrderRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private ProductFeign productFeign;

    @Autowired
    private InventoryFeign inventoryFeign;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {

        try{
            productFeign.getProductById(order.getId());
        }
        catch (FeignException.NotFound ex){
            throw  new ResourceNotFoundException("Product with id " + order.getId() +" not found");
        }

        try{
            inventoryFeign.getInventoryById(
                    order.getProductId()
            );
        }
        catch (FeignException.NotFound ex){
            throw  new ResourceNotFoundException("Product with productId "+ order.getProductId() + " not found");
        }

        try{
            inventoryFeign.reserve(
                    order.getProductId(),
                    order.getQuantity()
            );
        }
        catch(FeignException.Conflict ex){
            throw new InsufficientException("Insufficient stock");
        }

        order.setStatus("CREATED");
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order not found")
        );
    }
}
