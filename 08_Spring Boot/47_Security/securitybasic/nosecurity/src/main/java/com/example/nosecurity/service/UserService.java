package com.example.nosecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nosecurity.model.dto.UserDto;
import com.example.nosecurity.model.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // join (가입) -> insert
    public void joinUser(UserDto dto) throws Exception {
        /*
         * 1. userId가 admin이라면 권한 admin을 줌
         * 2. 그 외의 user에게는 권한 GENERAL(일반 사용자 권한)을 줌 (default: GENERAL)
         */
        dto.setUserRole("GENERAL"); // 서비스에 들어가는 비즈니스 로직 (검증)

        // 만약 userId가 admin이면
        if (dto.getUserId().equals("admin")) {
            dto.setUserRole("ADMIN");
        }
        userRepository.save(dto);
    }

    // login -> select
    public UserDto loginUser(UserDto dto) throws Exception {
        /*
         * 1. userId 값이 존재하는지
         * 1-1. 존재한다면 2번 실행
         * 1-2. 존재하지 않는다면 사용자가 없다고 메세지 출력
         * 2. 존재한다면 해당 비밀번호와 userPw가 같은지
         * 2-1. 같으면 로그인 성공
         * 2-2. 다르면 비밀번호가 다르다고 메시지 출력
         */
        UserDto user = userRepository.getUserDtoByUserId(dto.getUserId());
        log.info("[]"+ user);
        // 1-2
        if (user == null) {
            return null;
        }
        // 2.
        else if (!user.getUserPassword().equals(dto.getUserPassword())) {
            return dto; // dto는 id, pw에 대한 정보만 있고, email, role에 대한 정보는 없음
            // 실패하면 dto로, 성공하면 user로
        }
        return user;
    }
}
