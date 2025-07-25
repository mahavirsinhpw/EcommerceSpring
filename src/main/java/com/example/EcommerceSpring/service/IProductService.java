package com.example.EcommerceSpring.service;

import com.example.EcommerceSpring.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductService {

    List<ProductDTO> getProductsByCategory(String category)throws IOException;

    ProductDTO getProductById(Long id) throws  IOException;

    List<ProductDTO> getAllProducts() throws IOException;

    ProductDTO createProduct(ProductDTO productDTO);
}
