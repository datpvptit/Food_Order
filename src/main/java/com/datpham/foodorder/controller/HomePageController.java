package com.datpham.foodorder.controller;

import com.datpham.foodorder.dto.CategoryDTO;
import com.datpham.foodorder.dto.FoodDTO;
import com.datpham.foodorder.entities.Category;
import com.datpham.foodorder.payload.ResponseData;
import com.datpham.foodorder.service.CategoryService;
import com.datpham.foodorder.service.FileService;
import com.datpham.foodorder.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomePageController {
    private final CategoryService categoryService;
    private final FileService fileService;
    private final FoodService foodService;
    @GetMapping("/category")
    public ResponseEntity<?> getHomePageCategory(){
        ResponseData responseData = new ResponseData();
        List<CategoryDTO> categoryDTOList = categoryService.getCategoryHomePage();
        if(categoryDTOList!= null){
            responseData.setData(categoryDTOList);
            responseData.setSuccess(true);
        } else {
            responseData.setData("Can't get homepage category");
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/file/{target}/{filename:.+}")
    public ResponseEntity<?> getFile( @PathVariable String target, @PathVariable String filename){
        Resource resource = fileService.loadFile(filename, target);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }
}
