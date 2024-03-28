package com.example.exceptionbasic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptionbasic.model.dto.ProductDto;
import com.example.exceptionbasic.model.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public void insertProduct(ProductDto dto) throws Exception {
    //     if(dto.checkProductType() == null) {
    //         throw new Exception("유저 종류 오류");
    //     }
    //     productRepository.save(dto);
    // }
        dto.checkProductType();
        productRepository.save(dto);
    }

    public ProductDto selectByProductName(String productName) throws Exception {
        return productRepository.getReferenceById(productName); // 오류가 안나면 enum 반환
    }
}
