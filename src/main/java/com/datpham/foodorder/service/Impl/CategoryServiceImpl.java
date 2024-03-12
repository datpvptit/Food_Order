package com.datpham.foodorder.service.Impl;

import com.datpham.foodorder.dto.CategoryDTO;
import com.datpham.foodorder.dto.FoodDTO;
import com.datpham.foodorder.entities.Category;
import com.datpham.foodorder.entities.Food;
import com.datpham.foodorder.entities.RatingFood;
import com.datpham.foodorder.repository.CategoryRepository;
import com.datpham.foodorder.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public boolean addCateGory(String name) {
        Category category = new Category();
        category.setNameCate(name);
        Category cate = new Category();
        if(categoryRepository.findByNameCate(name) != null){
            return false;
        }
        try {
            cate = categoryRepository.save(category);
            return true;
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByNameCate(name);
    }

    @Override
    public List<CategoryDTO> getCategoryHomePage() {
        PageRequest pageRequest = PageRequest.of(0, 6);
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        Page<Category> categoryList = categoryRepository.findAll(pageRequest);
        for (Category category : categoryList){
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setName(category.getNameCate());
            List<FoodDTO> foodDTOList = new ArrayList<>();
            for(Food food : category.getListFood()){
                FoodDTO foodDTO = new FoodDTO();
                foodDTO.setId(food.getId());
                foodDTO.setPrice(food.getPrice());
                foodDTO.setTitle(food.getTitle());
                foodDTO.setImage(food.getImage());
                foodDTO.setMaterial(food.getMaterial());
                foodDTO.setDetail(food.getDetail());
                foodDTO.setTimeServe(food.getTimeServe());
                foodDTOList.add(foodDTO);
            }
            categoryDTO.setFoodDTOList(foodDTOList);
            categoryDTOList.add(categoryDTO);
        }
        Collections.reverse(categoryDTOList);
        return categoryDTOList;
    }

    @Override
    public boolean updateCategory(String name, String newName) {
        boolean isSuccess = false;

        try {
            Category category = categoryRepository.findByNameCate(name);
            if(category != null){
                category.setNameCate(newName);
                categoryRepository.save(category);
                isSuccess = true;
            }
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }

        return isSuccess;
    }

    @Override
    public boolean deleteCategory(String name) {
        boolean isSuccess = false;

        try {
            categoryRepository.deleteByNameCate(name);
            isSuccess = true;
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }

        return isSuccess;
    }

    private double calculateFoodRating(List<RatingFood> ratingFoodList){
        double total = 0;
        for(RatingFood ratingFood : ratingFoodList){
            total += ratingFood.getRatePoint();
        }

        DecimalFormat df = new DecimalFormat("#.#");
        return Double.parseDouble(df.format(total/ratingFoodList.size()));
    }
}
