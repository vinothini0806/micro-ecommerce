package com.java1.productservice.service;

import com.java1.productservice.model.Product;
import com.java1.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.java1.productservice.dto.ProductRequest;
import com.java1.productservice.dto.ProductResponse;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved ",product.getId());
    }
    public List<ProductResponse> getAllProducts(){
        List<Product> products  = productRepository.findAll();
        return products.stream().map(this::mapToResponse).toList();
    }

    private ProductResponse mapToResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
    
}
