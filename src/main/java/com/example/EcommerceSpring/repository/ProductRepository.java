package com.example.EcommerceSpring.repository;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface ProductRepository extends JpaRepository<Product,Long> {


}
