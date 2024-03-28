package com.example.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.model.dto.ProductDto;
import com.example.practice.service.ProductService;


@RestController
@RequestMapping("/api/v1/product/")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping("/insert")
    public String insertProduct(@RequestBody ProductDto dto) {
        productService.insertProduct(dto);
        return "저장 성공";
    }
    @GetMapping("/find/{productName}")
    public String findByProductName(@PathVariable String productName) {
        ProductDto dto = productService.findByProductName(productName);
        return dto.toString();
    }
    @GetMapping("/delete/{productName}")
    public String deleteProduct(@PathVariable String productName) {
        productService.deleteProduct(productName);
        return "삭제 성공";
    }
    @PostMapping("/update")
    public String updateProduct(@RequestBody ProductDto dto) {
        productService.updateProduct(dto);
        return "수정 성공";
    }
}
