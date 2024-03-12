package com.datpham.foodorder.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Entity(name="orders")
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users user;
    @ManyToOne
    @JoinColumn(name="res_id")
    private Restaurant restaurant;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "time_serve")
    private int timeServe;

    @Column(name = "total_price")
    private double totalPrice;


    @OneToMany(mappedBy = "order")
    private Set<OrderItem> listOrderItem;

    @OneToOne(mappedBy = "order")
    private Payment payment;
}
