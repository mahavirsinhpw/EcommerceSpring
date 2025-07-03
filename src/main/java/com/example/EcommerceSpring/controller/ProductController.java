package com.example.EcommerceSpring.controller;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.service.ICategoryService;
import com.example.EcommerceSpring.service.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private IProductService iProductService;

    public ProductController(IProductService iProductService){
        this.iProductService = iProductService;
    }

    @GetMapping("/category/{category}")
    public List<ProductDTO> getProductsByCategory(@PathVariable String category) throws IOException {
        return iProductService.getProductsByCategory(category);
    }

    @GetMapping("/id/{id}")
    public ProductDTO getProductById(@PathVariable int id) throws IOException{
        return iProductService.getProductById(id);
    }
}
