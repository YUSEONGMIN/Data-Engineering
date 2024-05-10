package com.example.springjpa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {
    // 엔티티와 구조가 같을 때도 있으나 다를 때도 있다.
    // 엔티티는 테이블 구조에 맞춰서 만들고, DTO은 사용자에 맞춰서
    private String productName;
    private int productPrice;
    private String companyName;


}
