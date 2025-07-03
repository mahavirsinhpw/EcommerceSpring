package com.example.EcommerceSpring.gateway.api;

import com.example.EcommerceSpring.dto.FakeStoreProductResponseDTO;
import com.example.EcommerceSpring.dto.FakeStoreSingleProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.io.IOException;

public interface FakeStoreProductApi {

    @GET("products/category")
    Call<FakeStoreProductResponseDTO> getProductsByCategory(@Query("type") String type) throws IOException;

    @GET("products/{id}")
    Call<FakeStoreSingleProductResponseDTO> getProduct(@Path("id") int id) throws IOException;
}
