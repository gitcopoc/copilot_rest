package com.example.gitco.service;

import com.example.gitco.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> findOrdersByOrderIdAndCustomerIdGreaterThanTen(Integer orderId);
}