package com.example.EcommerceSpring.service;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.entity.Product;
import com.example.EcommerceSpring.mapper.ProductMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import com.example.EcommerceSpring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Component("productService")
public class ProductService implements IProductService{

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repository,CategoryRepository categoryRepository){
        this.repository= repository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String category) throws IOException {
        return List.of();
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
       return repository.findById(id)
                .map(ProductMapper:: toDTO)
                .orElseThrow( ()-> new RuntimeException("product not found"));

    }

    @Override
    public List<ProductDTO> getAllProducts() throws IOException {
        return List.of();
    }



    public ProductDTO createProduct(ProductDTO productDTO){
        Category category = this.categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category not found"));

       Product product = ProductMapper.toEntity(productDTO,category);
       Product savedProduct = this.repository.save(product);
       return ProductMapper.toDTO(savedProduct);

    }
}
