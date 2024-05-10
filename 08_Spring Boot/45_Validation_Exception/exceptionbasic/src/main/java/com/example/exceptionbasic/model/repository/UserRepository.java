package com.example.exceptionbasic.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exceptionbasic.model.dto.UserDto;

// dto 만든 후 레파지토리 생성
public interface UserRepository extends JpaRepository<UserDto, String> {
    
}
