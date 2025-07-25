package com.example.EcommerceSpring.service;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.gateway.ICategoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService{

    private final ICategoryGateway iCategoryGateway;

    public FakeStoreCategoryService(@Qualifier("fakeStoreCategoryRestTemplateGateway")ICategoryGateway iCategoryGateway){
        this.iCategoryGateway = iCategoryGateway;
    }

    @Override
    public List<CategoryDTO> getALlCategories() throws IOException {
        return iCategoryGateway.getAllCategories();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return null;
    }


}
