package com.datpham.foodorder.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {
    private String name;
    private List<FoodDTO> foodDTOList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FoodDTO> getFoodDTOList() {
        return foodDTOList;
    }

    public void setFoodDTOList(List<FoodDTO> foodDTOList) {
        this.foodDTOList = foodDTOList;
    }
}
