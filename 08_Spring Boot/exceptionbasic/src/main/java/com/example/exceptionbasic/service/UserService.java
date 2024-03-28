package com.example.exceptionbasic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptionbasic.exception.UserException;
import com.example.exceptionbasic.model.dto.UserDto;
import com.example.exceptionbasic.model.repository.UserRepository;

// 레파지토리 생성 후 서비스 생성
// dao를 만들지 않았다면 dao 역할도 같이 + 비즈니스 로직인 서비스까지
// 일반적으론 dao와 엔티티를 만듦
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public void insertUser(UserDto dto) throws Exception { // throws Exception 붙이기 -> 비효율적인 방법 -> enum 사용하기
        
        if(!dto.getUserType().equals("일반사용자")
        && !dto.getUserType().equals("관리자")
        && !dto.getUserType().equals("매니저")) {
            // throw new Exception("유저 종류 오류");
            throw new UserException("유저 종류 오류");
        }
        userRepository.save(dto);
    }

    public UserDto selectByUserName(String userName) throws Exception {
        return userRepository.getReferenceById(userName);
    }
    // public UserDto selectByUserName(String userName) throws Exception {
    //     return userRepository.getReferenceById(userName);
    // }
}
