package com.example.EcommerceSpring.controller;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.service.ICategoryService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{category}")
    public List<ProductDTO> getProductsByCategory(@PathVariable String category) throws IOException{
        return iCategoryService.getProductsByCategory(category);
    }

}
