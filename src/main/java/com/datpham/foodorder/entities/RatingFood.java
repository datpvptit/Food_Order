package com.datpham.foodorder.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="rating_food")
@Getter
@Setter
public class RatingFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "content")
    private String content;

    @Column(name = "rate_point")
    private int ratePoint;
}
