package com.datpham.foodorder.entities;

import com.datpham.foodorder.Keys.IdOrderDetail;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity(name = "order_item")
@Setter
@Getter
public class OrderItem {
    @EmbeddedId
    private IdOrderDetail idOrderDetail;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "food_id", insertable = false, updatable = false)
    private Food food;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "number")
    private int number;

}

