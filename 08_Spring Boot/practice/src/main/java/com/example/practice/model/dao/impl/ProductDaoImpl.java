package com.example.practice.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.model.dao.ProductDao;
import com.example.practice.model.entity.ProductEntity;
import com.example.practice.model.repository.ProductRepository;

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
