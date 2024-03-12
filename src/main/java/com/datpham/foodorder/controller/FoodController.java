package com.datpham.foodorder.controller;

import com.datpham.foodorder.dto.FoodDTO;
import com.datpham.foodorder.payload.ResponseData;
import com.datpham.foodorder.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {


    private final FoodService foodService;

    @PreAuthorize("hasAuthority('SUPERADMIN')")
    @PostMapping("/add")
    public ResponseEntity<?> addFood(@RequestParam MultipartFile file,
                                     @RequestParam String title,
                                     @RequestParam double price,
                                     @RequestParam String material,
                                     @RequestParam String detail,
                                     @RequestParam int timeServe,
                                     @RequestParam String category_name){
        ResponseData responseData = new ResponseData();
        boolean isSuccess = foodService.addFood(file, title, price, material, detail, timeServe, category_name);
        if(isSuccess){
            responseData.setData("Add food successfully !");
            responseData.setSuccess(true);
        }else{
            responseData.setData("Can't add the food");
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SUPERADMIN')")
    @PostMapping("/update")
    public ResponseEntity<?> updateFood(@RequestParam int id,
                                        @RequestParam MultipartFile file,
                                        @RequestParam String title,
                                        @RequestParam double price,
                                        @RequestParam String material,
                                        @RequestParam String detail,
                                        @RequestParam int timeServe,
                                        @RequestParam String category_name){
        ResponseData responseData = new ResponseData();
        boolean isSuccess = foodService.updateFood(id, file, title, price, material, detail, timeServe, category_name);
        if(isSuccess){
            responseData.setData("Update food successfully !");
            responseData.setSuccess(true);
        }else{
            responseData.setData("Can't Update the food");
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SUPERADMIN')")
    @PostMapping("/delete")
    public ResponseEntity<?> deleteFood(@RequestParam int id){
        ResponseData responseData = new ResponseData();
        boolean isSuccess = foodService.deleteFood(id);
        if(isSuccess){
            responseData.setData("Delete food successfully !");
            responseData.setSuccess(true);
        }else{
            responseData.setData("Can't delete the food");
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SUPERADMIN')")
    @PostMapping ("/getAll")
    public ResponseEntity<?> getAllCategory(){
        ResponseData responseData = new ResponseData();
        List<FoodDTO> foodDTOList = foodService.getAll();
        if(foodDTOList != null){
            responseData.setData(foodDTOList);
            responseData.setSuccess(true);
        }else{
            responseData.setData("Can't add the category");
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
