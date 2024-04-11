package com.example.springmaven.controller;
// HTTP 통신

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


// Bean으로 등록해야 실행됨

@Slf4j // 로그 수집 - lombok에서 지원
@RestController
public class ControllerGet {

    @GetMapping("/hello")
        public String getHello() { 
            log.info("[ControllerGet][getHello] Start");
            return "Hello World";    
        }
    
    @GetMapping("/variable1/{param}")
    public String getVariable1(@PathVariable String param) {
        log.info("[ControllerGet][getHello] param: " + param);
        return "GetMapping's params: " + param;
    }
}
