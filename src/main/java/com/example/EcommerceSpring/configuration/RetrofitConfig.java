package com.example.EcommerceSpring.configuration;

import com.example.EcommerceSpring.gateway.api.FakeStoreCategoryApi;
import com.example.EcommerceSpring.gateway.api.FakeStoreProductApi;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {


//    private static final String base_url = System.getProperty("fakeStoreApi_base_url");


    @Bean
    public Retrofit retrofit(FakeStoreApiConfig fakeStoreApiConfig){
        return new Retrofit
                .Builder()
                .baseUrl(fakeStoreApiConfig.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit){
        return retrofit.create(FakeStoreCategoryApi.class);
    }

    @Bean
    public FakeStoreProductApi fakeStoreProductApi(Retrofit retrofit){
        return retrofit.create(FakeStoreProductApi.class);
    }


}
