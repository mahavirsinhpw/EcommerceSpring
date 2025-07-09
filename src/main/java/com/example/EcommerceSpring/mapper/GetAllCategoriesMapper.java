package com.example.EcommerceSpring.mapper;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;

import java.util.List;

public class GetAllCategoriesMapper {

    public static FakeStoreCategoryResponseDTO toFakeStoreCategoryResponseDTO(CategoryDTO categoryDTO){

        return null;
    }

    public static List<CategoryDTO> toCategoryDTO(FakeStoreCategoryResponseDTO fakeStoreCategoryResponseDTO){

        return fakeStoreCategoryResponseDTO.getCategories()
                .stream()
                .map(category-> CategoryDTO.builder().name(category).build())
                .toList();
    }
}
