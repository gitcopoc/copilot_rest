package com.example.gitco.controller;

import com.example.gitco.model.Order;
import com.example.gitco.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/search/{orderId}")
    public List<Order> findOrdersByOrderIdAndCustomerIdGreaterThanTen(@PathVariable Integer orderId) {
        return orderService.findOrdersByOrderIdAndCustomerIdGreaterThanTen(orderId);
    }
}