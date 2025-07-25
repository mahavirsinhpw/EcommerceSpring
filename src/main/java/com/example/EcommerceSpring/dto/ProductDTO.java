package com.example.EcommerceSpring.dto;

import com.example.EcommerceSpring.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private Long id;
    private String title;
    private String image;
    private int price;
    private String description;
    private String brand;
    private String model;
    private String color;
    private Long categoryId;
    private Boolean popular;
    private int discount;
    private boolean onSale;


}
