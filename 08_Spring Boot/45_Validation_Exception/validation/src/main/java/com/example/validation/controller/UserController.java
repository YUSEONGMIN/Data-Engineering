package com.example.validation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.model.dto.UserDto;
import com.example.validation.model.dto.UserValiDto;
import com.example.validation.service.UserService;

import jakarta.validation.Valid;


// 4. 서비스 생성 후 컨트롤 생성

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    
    @Autowired
    private UserService uService;
    
    // 서비스 함수명

    @GetMapping("/select/{id}")
    public String getReferenceById(@PathVariable String id) {
        return uService.getReferenceById(id).toString();
    }

    // localhost:8080/api/v1/user/insert
    @PostMapping("/insert")
    public String insertUser(@RequestBody UserDto dto) {
        uService.insertUser(dto);
        return "저장 성공";
    }

    // localhost:8080/api/v1/user/insert/withtry
    // 전통적인 임시방식
    // 이러한 방식은 컨트롤, 서비스 등 모든 방법에 적용해야 하는 불편함
    @PostMapping("/insert/withtry")
    public String insertUserWithTry(@RequestBody UserDto dto) {
        try {
            if(dto.getPassword() == null || dto.getPassword().isEmpty()) {
                throw new Exception("비번이 없어요");
            }
            uService.insertUser(dto);
            return "저장 성공";
        } catch (Exception e) {
            // TODO: handle exception
            return "오류 발생 > " + e.getMessage();
        }
    }

    @PostMapping("/insert/withvalid")
    public String insertUserWithVali(@Valid @RequestBody UserValiDto dto) { // @Valid 사용하면 검사 가능
            uService.insertUserWithVali(dto);
            return "저장 성공";
    }

}
