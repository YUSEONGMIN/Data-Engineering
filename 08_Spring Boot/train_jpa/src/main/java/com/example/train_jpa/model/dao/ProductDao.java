package com.example.train_jpa.model.dao;

import com.example.train_jpa.model.entitiy.ProductEntity;

public interface ProductDao {
    public ProductEntity findByProductName(String productName);
    public void insertProduct(ProductEntity entity);
    public void updateProduct(ProductEntity entity);
    public void deleteProduct(Long id);
}
