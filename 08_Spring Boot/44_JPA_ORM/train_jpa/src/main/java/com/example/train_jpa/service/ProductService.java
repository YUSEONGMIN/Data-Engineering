package com.example.train_jpa.service;

import com.example.train_jpa.model.dto.ProductDto;

public interface ProductService {
    public void insertProduct(ProductDto dto);
    public ProductDto findByProductName(String productName);
    public void updateProduct(ProductDto dto);
    public void deleteProduct(String productName);
}
