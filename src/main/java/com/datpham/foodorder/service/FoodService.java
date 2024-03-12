package com.datpham.foodorder.service;

import com.datpham.foodorder.dto.FoodDTO;
import com.datpham.foodorder.entities.Category;
import com.datpham.foodorder.entities.Food;
import jakarta.persistence.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FoodService {
    boolean addFood(    MultipartFile file,
                        String title,
                        double price,
                        String material,
                        String detail,
                        int timeServe,
                        String category_name);

    boolean updateFood( int id,
                        MultipartFile file,
                        String title,
                        double price,
                        String material,
                        String detail,
                        int timeServe,
                        String category_name);
    boolean deleteFood(int id);

    List<FoodDTO> getAll();
}
