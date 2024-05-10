package com.example.nosecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nosecurity.model.dto.UserDto;
import com.example.nosecurity.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class ApiUserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/join")
    public String joinUser(@Valid @RequestBody UserDto dto) throws Exception {
        userService.joinUser(dto);
        return "가입 성공";
    }

    @PostMapping("/login")
    public String loginUser(@Valid @RequestBody UserDto dto) throws Exception {
        String loginResult = "";
        UserDto login = userService.loginUser(dto);
        log.info("[loginResult]: " + login);
        
        if (login == null) {
            loginResult = "사용자 없음 / 신규 가입";
        } else if (login.getUserPassword() == null) {
            loginResult = " 비밀번호 재입력";
        } else {
            loginResult = login.toString();
        }
        return loginResult;
    }
}
