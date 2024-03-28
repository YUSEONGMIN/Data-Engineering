package com.example.springbasic.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbasic.model.User2Dto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/post") // post: 데이터 조작
public class ContorllerPost {

    // localhost:8080/api/v1/post/variable1
    @PostMapping("/variable1")
    public String postVariable1(@RequestBody Map<String, Object> params) {
        log.info("[ControllerPost][postVariable1] Start");
        params.forEach((strKey, strValue)->{
            log.info("[postVariable1] " + strKey + " : " + strValue);
        }); 
        return "postVariable1";
    }
    // post는 body 영역에 키-밸류를 전송해야 함 body-raw-json

    // localhost:8080/api/v1/post/variable2
    @PostMapping("/variable2")
    public String postVariable2(@RequestBody User2Dto dto) {
        log.info("[ControllerPost][postVariable2] Start");
        
        log.info(dto.toString());
        return "postVariable2";
    }
    
    
}
