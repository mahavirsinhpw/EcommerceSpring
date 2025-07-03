package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {

    List<ProductDTO> getProductsByCategory(String category) throws IOException;

    ProductDTO getProductById(int id) throws IOException;
}
