package com.datpham.foodorder.dto;

import com.datpham.foodorder.entities.Category;
import com.datpham.foodorder.entities.Food;
import com.datpham.foodorder.entities.MenuRestaurant;
import com.datpham.foodorder.entities.RatingFood;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class FoodDTO {
    private int id;
    private String image;
    private String title;
    private double price;
    private String material;
    private String detail;
    private int timeServe;
    private CategoryDTO categoryDTO;
}
