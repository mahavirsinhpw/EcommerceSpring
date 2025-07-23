package com.example.EcommerceSpring.service;

import com.example.EcommerceSpring.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService implements IProductService{
    @Override
    public List<ProductDTO> getProductsByCategory(String category) throws IOException {
        return List.of();
    }

    @Override
    public ProductDTO getProductById(int id) throws IOException {
        return null;
    }

    @Override
    public List<ProductDTO> getAllProducts() throws IOException {
        return List.of();
    }
}
