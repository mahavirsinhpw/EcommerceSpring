package com.example.EcommerceSpring.mapper;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.entity.Product;

public class ProductMapper {

    public static ProductDTO toDTO(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .price(product.getPrice())
                .color(product.getColor())
                .model(product.getModel())
                .brand(product.getBrand())
                .title(product.getTitle())
                .image(product.getImage())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .onSale(product.isOnSale())
                .categoryId(product.getCategory().getId())
                .popular(product.getPopular())
                .build();
    }

    public static Product toEntity(ProductDTO productDTO, Category category){
        return Product.builder()
                .price(productDTO.getPrice())
                .color(productDTO.getColor())
                .model(productDTO.getModel())
                .brand(productDTO.getBrand())
                .title(productDTO.getTitle())
                .image(productDTO.getImage())
                .description(productDTO.getDescription())
                .discount(productDTO.getDiscount())
                .onSale(productDTO.isOnSale())
                .category(category)
                .popular(productDTO.getPopular())
                .build();
    }
}
