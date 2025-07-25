package com.example.EcommerceSpring.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product extends BaseEntity{


    private String title;
    private String image;
    private int price;
    private String description;
    private String brand;
    private String model;
    private String color;
//  private String category;
    private Boolean popular;
    private int discount;
    private boolean onSale;

    @ManyToOne
    @JoinColumn(name = "categoryId",nullable = false)
    private Category category;

}
