package com.example.EcommerceSpring.service;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> getALlCategories() throws IOException;

    List<ProductDTO> getProductsByCategory(String category)throws IOException;
}
