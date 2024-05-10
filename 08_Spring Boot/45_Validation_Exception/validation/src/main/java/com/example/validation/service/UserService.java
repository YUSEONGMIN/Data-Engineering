package com.example.validation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.validation.model.dao.UserDao;
import com.example.validation.model.dto.UserDto;
import com.example.validation.model.dto.UserValiDto;
import com.example.validation.model.entity.UserEntity;

// 3. Dao 생성 후 서비스 생성

@Service
public class UserService {
    
    @Autowired
    private UserDao uDao;

    /*
     * 비즈니스 로직
     * 저장 후 저장된 내용 조회
     */

     // dao 함수명 그대로
     // without validation (validation이 적용되지 않은 dto)
    public void insertUser(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setAge(dto.getAge());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());

        uDao.insertUser(entity);
    }

    // validation
    public void insertUserWithVali(UserValiDto dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setAge(dto.getAge());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());

        uDao.insertUser(entity);
    }

    // 조회
    public UserDto getReferenceById(String id) {
        UserEntity entity = uDao.getReferenceById(id);
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        dto.setAge(entity.getAge());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());

        return dto;
    }

}
