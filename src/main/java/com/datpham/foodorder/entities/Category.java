package com.datpham.foodorder.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity(name="category")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name_cate")
    private String nameCate;

    @Column(name="create_date")
    private Date createDate;

    @OneToMany(mappedBy = "category")
    private List<Food> listFood;

    @OneToMany(mappedBy = "category")
    private List<MenuRestaurant> listMenuRestaurant;

}
