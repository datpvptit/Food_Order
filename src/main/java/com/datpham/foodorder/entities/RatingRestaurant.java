package com.datpham.foodorder.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "RatingRestaurant")
@Getter
@Setter
public class RatingRestaurant {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "res_id")
    private Restaurant restaurant;

    @Column(name = "content")
    private  String content;

    @Column(name = "rate_point")
    private  int ratePoint;

}