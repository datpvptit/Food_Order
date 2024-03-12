package com.datpham.foodorder.Keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class IdMenuRestaurant implements Serializable {
    @Column(name = "cate_id")
    private int categoryId;
    @Column(name = "res_id")
    private int restaurantID;

    public IdMenuRestaurant() {
    }

    public IdMenuRestaurant(int categoryId, int restaurantID) {
        this.categoryId = categoryId;
        this.restaurantID = restaurantID;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }
}
