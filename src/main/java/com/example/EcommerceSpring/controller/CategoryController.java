package com.example.EcommerceSpring.controller;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.service.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.SpinnerUI;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {


    private ICategoryService iCategoryService;

    public CategoryController(ICategoryService iCategoryService){
        this.iCategoryService = iCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() throws IOException {
        List<CategoryDTO> categories = this.iCategoryService.getALlCategories();
        return ResponseEntity.ok(categories);
    }



}
