package com.datpham.foodorder.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name="food")
@Setter
@Getter
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="image")
    private String image;

    @Column(name="title")
    private String title;
    @Column(name="price")
    private double price;
    @Column(name="material")
    private String material;

    @Column(name="detail")
    private String detail;

    @Column(name="time_serve")
    private int timeServe;

    @ManyToOne
    @JoinColumn(name="cate_id")
    private Category category;

    @OneToMany(mappedBy = "food")
    private List<RatingFood> ratingFoodList;

}
