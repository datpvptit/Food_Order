package com.datpham.foodorder.repository;

import com.datpham.foodorder.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    List<Food> findTop3ByOrderById();
    Food findFoodById(int id);
    void deleteById(int id);
}
