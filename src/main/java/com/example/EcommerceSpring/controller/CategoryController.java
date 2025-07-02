package com.example.EcommerceSpring.controller;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.service.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<CategoryDTO> getAllCategories() throws IOException {
        return iCategoryService.getALlCategories();


    }

}
