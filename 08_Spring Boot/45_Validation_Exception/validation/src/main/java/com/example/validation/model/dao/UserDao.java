package com.example.validation.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.validation.model.entity.UserEntity;
import com.example.validation.model.repository.UserRepository;

// 레파지토리 생성 후 Dao 생성
@Service
public class UserDao {

    @Autowired
    private UserRepository uRepository;

    // 저장
    public void insertUser(UserEntity entity) {
        uRepository.save(entity);
    }

    // 조회
    public UserEntity getReferenceById(String id) { // JpaRepository에서 기본적으로 제공하는 함수
        return uRepository.getReferenceById(id);
    }
}
