package com.example.train_jpa.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.train_jpa.model.dao.ProductDao;
import com.example.train_jpa.model.entitiy.ProductEntity;
import com.example.train_jpa.model.repository.ProductRepository;

@Service
public class ProductDaoImpl implements ProductDao{
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductEntity findByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public void insertProduct(ProductEntity entity) {
        productRepository.save(entity);
    }

    @Override
    public void updateProduct(ProductEntity entity) {
        productRepository.save(entity);
    }
    
}
