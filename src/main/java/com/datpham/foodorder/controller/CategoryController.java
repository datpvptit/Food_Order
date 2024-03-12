package com.datpham.foodorder.controller;

import com.datpham.foodorder.payload.ResponseData;
import com.datpham.foodorder.service.CategoryService;
import com.datpham.foodorder.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PreAuthorize("hasAuthority('SUPERADMIN')")
    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestParam String name){
        ResponseData responseData = new ResponseData();
        boolean isSuccess = categoryService.addCateGory(name);
        if(isSuccess){
            responseData.setData(categoryService.findByName(name));
            responseData.setSuccess(true);
        }else{
            responseData.setData("Can't add the category");
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SUPERADMIN')")
    @PostMapping("/update")
    public ResponseEntity<?> updateCategory(@RequestParam String name, @RequestParam String newName){
        ResponseData responseData = new ResponseData();
        boolean isSuccess = categoryService.updateCategory(name, newName);
        if(isSuccess){
            responseData.setData(categoryService.findByName(name));
            responseData.setSuccess(true);
        }else{
            responseData.setData("Can't update the category");
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SUPERADMIN')")
    @PostMapping("/delete")
    public ResponseEntity<?> deleteCategory(@RequestParam String name){
        ResponseData responseData = new ResponseData();
        boolean isSuccess = categoryService.deleteCategory(name);
        if(isSuccess){
            responseData.setData("Delete category " + name + "successfully !");
            responseData.setSuccess(true);
        }else{
            responseData.setData("Can't delete the category");
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
