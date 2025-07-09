package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.configuration.FakeStoreApiConfig;
import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.mapper.GetAllCategoriesMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreCategoryRestTemplateGateway")
public class FakeStoreCategoryRestTemplateGateway implements ICategoryGateway{


    private final RestTemplate restTemplate;
    private FakeStoreApiConfig fakeStoreApiConfig;

    public FakeStoreCategoryRestTemplateGateway(RestTemplate restTemplate,FakeStoreApiConfig fakeStoreApiConfig){
        this.restTemplate = restTemplate;
        this.fakeStoreApiConfig = fakeStoreApiConfig;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {


       String url = fakeStoreApiConfig.getBaseUrl();
       String baseUrl = url+"products/category";
       FakeStoreCategoryResponseDTO responseDto= this.restTemplate.getForEntity(baseUrl, FakeStoreCategoryResponseDTO.class).getBody();

       if (responseDto == null){
           throw new IOException("Failed to fetch category from fakeStore using restTemplate");
       }
//       return responseDto.getCategories()
//               .stream()
//               .map(category-> CategoryDTO.builder().name(category).build())
//               .toList();
        return GetAllCategoriesMapper.toCategoryDTO(responseDto);


    }
}
