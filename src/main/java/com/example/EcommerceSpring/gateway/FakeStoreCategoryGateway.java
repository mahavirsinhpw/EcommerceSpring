package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.dto.FakeStoreProductResponseDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi){
        this.fakeStoreCategoryApi=fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        FakeStoreCategoryResponseDTO responseDTO = fakeStoreCategoryApi.getAllCategories().execute().body();
        if(responseDTO == null){
            throw new IOException("failed to fetch categories from fake store api");
        }
         return   responseDTO.getCategories()
                                .stream()
                                .map(category-> CategoryDTO.builder().name(category).build())
                                .toList();
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String category) throws IOException {
        FakeStoreProductResponseDTO responseDTO = fakeStoreCategoryApi.getProductsByCategory(category).execute().body();
        if (responseDTO == null){
            throw  new IOException("failed to fetch products from fake store api");
        }

        return responseDTO.getProducts().stream()
                .map(
                        productDTO -> ProductDTO.builder()
                                .id(productDTO.getId())
                                .category(productDTO.getCategory())
                                .brand(productDTO.getBrand())
                                .color(productDTO.getColor())
                                .model(productDTO.getModel())
                                .price(productDTO.getPrice())
                                .title(productDTO.getTitle())
                                .description(productDTO.getDescription())
                                .image(productDTO.getImage())
                                .onSale(productDTO.isOnSale())
                                .discount(productDTO.getDiscount()).build()
                ).toList();




//        responseDTO.getProducts()
//                .stream()
//                .map()
    }
}
