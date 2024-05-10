package com.example.validation.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.validation.model.entity.UserEntity;

// 앤티티(테이블) 생성 후 레파지토리 생성
// 레파지토리는 유저 인터페이스
public interface UserRepository extends JpaRepository<UserEntity, String>{
    
}
