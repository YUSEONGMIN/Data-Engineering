package com.example.practice.service;

import com.example.practice.model.dto.ProductDto;

public interface ProductService {
    public void insertProduct(ProductDto dto);
    public ProductDto findByProductName(String productName);
    public void updateProduct(ProductDto dto);
    public void deleteProduct(String productName);
}
