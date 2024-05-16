package com.example.gitco.serviceimpl;

import com.example.gitco.model.Order;
import com.example.gitco.repository.OrderRepository;
import com.example.gitco.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findOrdersByOrderIdAndCustomerIdGreaterThanTen(Integer orderId) {
        return orderRepository.findOrdersByOrderIdAndCustomerIdGreaterThanTen(orderId);
    }
}