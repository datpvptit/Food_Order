package com.datpham.foodorder.Keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class IdOrderDetail implements Serializable {
    @Column(name = "order_id")
    private int orderID;
    @Column(name = "food_id")
    private int foodID;

    public IdOrderDetail() {
    }

    public IdOrderDetail(int orderID, int foodID) {
        this.orderID = orderID;
        this.foodID = foodID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }
}

