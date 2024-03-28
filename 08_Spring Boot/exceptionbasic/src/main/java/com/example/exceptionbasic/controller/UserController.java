package com.example.exceptionbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptionbasic.model.dto.UserDto;
import com.example.exceptionbasic.service.UserService;

import jakarta.validation.Valid;

// 서비스까지 만들었다면 컨트롤러 생성

@RestController
@RequestMapping("/api/v1/user") // api는 rest api를 의미
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public String insertUser(@Valid @RequestBody UserDto dto) throws Exception {
        userService.insertUser(dto);
        return "저장 성공";
    }

    @GetMapping("/select/{userName}")
    public String selectByUserName(@PathVariable String userName) throws Exception {
        return userService.selectByUserName(userName).toString();
    }
}
