package com.example.EcommerceSpring.service;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.mapper.CategoryMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Component("categoryService")
public class CategoryService implements ICategoryService{

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository){
        this.repository= repository;
    }

    @Override
    public List<CategoryDTO> getALlCategories() throws IOException {
        return List.of();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
       Category category = CategoryMapper.toEntity(categoryDTO);
       Category savedCategory = this.repository.save(category);
       return CategoryMapper.toDTO(savedCategory);


    }
}
