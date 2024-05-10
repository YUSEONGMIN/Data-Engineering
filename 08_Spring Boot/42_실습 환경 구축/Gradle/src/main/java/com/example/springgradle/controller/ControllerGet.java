package com.example.springgradle.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/get") // api로 통신/version별/ControllerGet -> url이 겹치지 않게하기 위함
public class ControllerGet {
    
    @GetMapping("/world") // GetMapping -> GET 요청만 받을 수 있음
    public String getWorld() {
        log.info("[ControllerGet][getWorld] Start");
        return "GetMapping >> Hello world";
    }

    @GetMapping("/hello")
    public String getHello() {
        log.info("[ControllerGet][getWorld] Start");
        return "Hello World";
    }
    // @GetMapping("/variable/{param}")
    // public String getParam(@PathVariable("param") String param) { // 강제 매핑 -> 이름이 달라도 가능 (문제가 없다면 자동매핑 가능)
    //     return param;
    // }    
    @GetMapping("/variable/{param}")
    public String getParam(@PathVariable("param") String param) {
        return "GetMapping >> param: " + param;
    }    
}