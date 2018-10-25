package com.example.demo;

import com.example.demo.Product;
import com.microsoft.azure.spring.data.documentdb.repository.DocumentDbRepository;


public interface ProductRepository extends DocumentDbRepository<Product, String> {
    @Override
    Product findOne(String id);

    @Override
    void delete(Product deleted);
}