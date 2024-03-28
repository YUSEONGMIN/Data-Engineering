package com.example.train_jpa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.train_jpa.model.entitiy.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
    public ProductEntity findByProductName(String productName);
}
