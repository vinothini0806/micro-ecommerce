package com.java1.productservice.repository;

import com.java1.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface ProductRepository extends MongoRepository<Product,String> {
}
