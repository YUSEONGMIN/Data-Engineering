package com.example.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjpa.model.dto.ProductDto;
import com.example.springjpa.service.ProductService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping("/insert")
    public String insertProduct(@RequestBody ProductDto dto) {
        productService.insertProduct(dto);
        log.info("[ProductController][insertProduct] Start");
        return "저장 성공";
    }

    @GetMapping("/find/{productName}")
    public String findByProductName(@PathVariable String productName) {
        ProductDto dto = productService.findByProductName(productName);
        log.info("[ProductController][findByProductName] Start");
        return dto.toString();
    }

    @GetMapping("/delete/{productName}")
    public String deleteProduct(@PathVariable String productName) {
        productService.deleteProduct(productName);
        return "삭제 성공";
    }

    @PostMapping("/update")
    public String updateProduct(@RequestBody ProductDto dto) {
        //TODO: process POST request
        productService.updateProduct(dto);
        return "수정 성공";
    }
    
    
}
