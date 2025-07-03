package com.example.EcommerceSpring.service;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.gateway.FakeStoreCategoryGateway;
import com.example.EcommerceSpring.gateway.ICategoryGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService{

    private final ICategoryGateway iCategoryGateway;

    public FakeStoreCategoryService(ICategoryGateway iCategoryGateway){
        this.iCategoryGateway = iCategoryGateway;
    }

    @Override
    public List<CategoryDTO> getALlCategories() throws IOException {
        return iCategoryGateway.getAllCategories();
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String category) throws IOException {
        return iCategoryGateway.getProductsByCategory(category);
    }

}
