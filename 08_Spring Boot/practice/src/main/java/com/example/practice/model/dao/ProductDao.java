package com.example.practice.model.dao;

import com.example.practice.model.entity.ProductEntity;

public interface ProductDao {
    public ProductEntity findByProductName(String productName);
    public void insertProduct(ProductEntity entity);
    public void updateProduct(ProductEntity entity);
    public void deleteProduct(Long id);

}
