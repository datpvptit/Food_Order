package com.datpham.foodorder.controller;


import com.datpham.foodorder.payload.ResponseData;
import com.datpham.foodorder.service.CategoryService;
import com.datpham.foodorder.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin
@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminRestController {

    private final CategoryService categoryService;
    private final FoodService foodService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/hello")
    public String sayHello ()
    { return "Hello" ;}


}
