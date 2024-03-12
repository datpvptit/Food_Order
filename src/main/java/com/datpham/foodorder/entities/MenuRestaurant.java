package com.datpham.foodorder.entities;

import com.datpham.foodorder.Keys.IdMenuRestaurant;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity(name="menu_restaurant")
@Getter
@Setter
public class MenuRestaurant {
    @EmbeddedId
    IdMenuRestaurant idMenuRestaurant;

    @ManyToOne
    @JoinColumn(name = "cate_id", insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "res_id", insertable = false, updatable = false)
    private Restaurant restaurant;
}
