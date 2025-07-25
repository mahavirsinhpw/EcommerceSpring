package com.example.EcommerceSpring.controller;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.service.IProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private IProductService iProductService;

    public ProductController(@Qualifier("productService") IProductService iProductService){
        this.iProductService = iProductService;
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable String category) throws IOException {
        List<ProductDTO> products = this.iProductService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws IOException{
        ProductDTO productDTO = this.iProductService.getProductById(id);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("/getAll")
    public  ResponseEntity<List<ProductDTO>> getAllProductsViaOkHttp() throws IOException{
        List<ProductDTO> products = this.iProductService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO product = this.iProductService.createProduct(productDTO);
        return ResponseEntity.ok(product);

    }
}
