package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.FakeStoreProductResponseDTO;
import com.example.EcommerceSpring.dto.FakeStoreSingleProductResponseDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.gateway.api.FakeStoreCategoryApi;
import com.example.EcommerceSpring.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreProductGateway implements IProductGateway {

    private final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi){
         this.fakeStoreProductApi = fakeStoreProductApi;
    }



    @Override
    public List<ProductDTO> getProductsByCategory(String category) throws IOException {
        FakeStoreProductResponseDTO responseDTO = fakeStoreProductApi.getProductsByCategory(category).execute().body();
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

    }

    @Override
    public ProductDTO getProductById(int id) throws IOException {
        FakeStoreSingleProductResponseDTO responseDTO = fakeStoreProductApi.getProduct(id).execute().body();

        if (responseDTO == null){
            throw new IOException("failed to fetch product by id :"+ id + " from fake store api ");
        }

        ProductDTO productDTO = responseDTO.getProduct();

       return ProductDTO.builder()
                .category(productDTO.getCategory())
                .image(productDTO.getImage())
                .brand(productDTO.getBrand())
                .color(productDTO.getColor())
                .onSale(productDTO.isOnSale())
                .id(productDTO.getId())
                .price(productDTO.getPrice())
                .model(productDTO.getModel())
                .title(productDTO.getTitle())
                .description(productDTO.getDescription())
                .discount(productDTO.getDiscount())
                .build();

    }
}
