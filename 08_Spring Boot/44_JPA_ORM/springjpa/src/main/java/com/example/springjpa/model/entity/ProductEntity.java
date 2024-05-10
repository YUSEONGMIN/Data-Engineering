package com.example.springjpa.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity(name = "ProductEntity") // Entity 정의. 엔티티 이름 그대로
@Table(name = "product") // 테이블 정의
public class ProductEntity { // ddl: 테이블 만들기
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // AUTOINCREMENT
    private Long id; // table에는 무조건 id 있어야
    
    // 일반 칼럼
    @Column(unique = true) // productName 이름은 unique
    private String productName;
    private int productPrice;
    private String companyName;
    // jpa가 자동으로 테이블을 만들어줌


}
