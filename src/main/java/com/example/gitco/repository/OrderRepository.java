package com.example.gitco.repository;
import com.example.gitco.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT o FROM Order o WHERE o.orderId = :orderId AND o.customerId > 10")
    List<Order> findOrdersByOrderIdAndCustomerIdGreaterThanTen(@Param("orderId") Integer orderId);
}
