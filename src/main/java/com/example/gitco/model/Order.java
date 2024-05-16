package com.example.gitco.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "orders", schema = "gitpocsch")
public class Order {

    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "order_status")
    private Integer orderStatus;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "required_date")
    private Date requiredDate;

    @Column(name = "shipped_date")
    private Date shippedDate;

    @Column(name = "store_id")
    private Integer storeId;

    @Column(name = "staff_id")
    private Integer staffId;
}