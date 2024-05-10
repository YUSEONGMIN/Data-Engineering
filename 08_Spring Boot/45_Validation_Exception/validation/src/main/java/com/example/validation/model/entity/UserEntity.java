package com.example.validation.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 2. dto 생성 후 엔티티 생성

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    private String id;
    private String name;
    private String password;
    private int age;
    private String email;
    private String phoneNumber;

}
