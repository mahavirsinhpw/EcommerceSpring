package com.example.EcommerceSpring.service;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.gateway.ICategoryGateway;
import com.example.EcommerceSpring.gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService{

    private final IProductGateway iProductGateway;

    public FakeStoreProductService(IProductGateway iProductGateway){
        this.iProductGateway = iProductGateway;
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String category) throws IOException {
        return iProductGateway.getProductsByCategory(category);
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        return iProductGateway.getProductById(id);
    }

    @Override
    public List<ProductDTO> getAllProducts() throws IOException {
        return iProductGateway.fetchAllProducts();
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        return null;
    }


}
