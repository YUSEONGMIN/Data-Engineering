package com.example.springjpa.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springjpa.model.dao.ProductDao;
import com.example.springjpa.model.entity.ProductEntity;
import com.example.springjpa.model.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductDaoImpl implements ProductDao{
    
    @Autowired
    private ProductRepository productRepository; 
    // ProductRepository 객체로 만들어짐 (커피빈 생성됨). 만들어진 객체는 Autowired로 자동 생성 가능

    @Override
    public void deleteProduct(Long id) {
        // TODO Auto-generated method stub
        log.info("[ProductDaoImpl][deleteProduct] Start");
        // ProductEntity entity = productRepository.getReferenceById(id); // getReferenceById 함수는 JPA 레파지토리에서 제공하는 기본함수
        // productRepository.delete(entity);
        productRepository.deleteById(id);

    }

    @Override
    public ProductEntity findByProductName(String productName) {
        // TODO Auto-generated method stub
        log.info("[ProductDaoImpl][findByProductName] Start");
        return productRepository.findByProductName(productName);
    }

    @Override
    public void insertProduct(ProductEntity entity) {
        // TODO Auto-generated method stub
        log.info("[ProductDaoImpl][insertProduct] Start");
        productRepository.save(entity);
        
    }

    @Override
    public void updateProduct(ProductEntity entity) {
        // TODO Auto-generated method stub
        log.info("[ProductDaoImpl][updateProduct] Start");
        productRepository.save(entity); // 기존 데이터가 있으면 update, 없으면 insert
        
    }
    
}
