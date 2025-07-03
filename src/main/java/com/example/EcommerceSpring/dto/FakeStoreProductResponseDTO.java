package com.example.EcommerceSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreProductResponseDTO {

    private String status;
    private String message;
    private List<ProductDTO> products;
}
