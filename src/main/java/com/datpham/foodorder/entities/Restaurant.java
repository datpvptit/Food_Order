package com.datpham.foodorder.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity(name = "restaurant")
@Setter
@Getter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="name")
    private String name;

    @Column(name="subtitle")
    private String subtitle;

    @Column(name="description")
    private String description;


    @Column(name="image")
    private String image;


    @Column(name="is_freeship")
    private boolean isFreeship;


    @Column(name="address")
    private String address;


    @Column(name="open_time")
    private Date openTime;

    @OneToMany(mappedBy = "restaurant")
    private List<MenuRestaurant> menuRestaurantList;
    @OneToMany(mappedBy = "restaurant")
    private List<Promo> promoList;

    @OneToMany(mappedBy = "restaurant")
    private List<Order> orderList;

    @OneToMany(mappedBy = "restaurant")
    private List<RatingRestaurant> ratingRestaurantList;
}
