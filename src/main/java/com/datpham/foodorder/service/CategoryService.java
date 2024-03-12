package com.datpham.foodorder.service;

import com.datpham.foodorder.dto.CategoryDTO;
import com.datpham.foodorder.entities.Category;

import java.util.List;

public interface CategoryService {
    boolean addCateGory(String name);
    Category findByName(String name);
    List<CategoryDTO> getCategoryHomePage();

    boolean updateCategory(String name, String newName);
    boolean deleteCategory(String name);

}
