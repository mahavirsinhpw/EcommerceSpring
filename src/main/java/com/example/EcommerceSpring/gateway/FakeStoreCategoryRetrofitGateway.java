package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.gateway.api.FakeStoreCategoryApi;
import com.example.EcommerceSpring.mapper.GetAllCategoriesMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Primary
public class FakeStoreCategoryRetrofitGateway implements ICategoryGateway{

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryRetrofitGateway(FakeStoreCategoryApi fakeStoreCategoryApi){
        this.fakeStoreCategoryApi=fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        FakeStoreCategoryResponseDTO responseDTO = fakeStoreCategoryApi.getAllCategories().execute().body();
        if(responseDTO == null){
            throw new IOException("failed to fetch categories from fake store api");
        }
//         return   responseDTO.getCategories()
//                                .stream()
//                                .map(category-> CategoryDTO.builder().name(category).build())
//                                .toList();
        return GetAllCategoriesMapper.toCategoryDTO(responseDTO);
    }


}
