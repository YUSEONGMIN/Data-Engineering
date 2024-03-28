package com.example.springbasic.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbasic.model.User1Dto;
import com.example.springbasic.model.User2Dto;
import com.example.springbasic.model.UserDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // 객체로 만들어서 인식할 수 있게
@RequestMapping("/api/v1/get") // 일반적으로 Request는 api로 시작하고 버전별로
public class ControllerGet {
    // localhost:8080/api/v1/get/hello
    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }

    @GetMapping("/header")
    public Map<String, Object> getHeader(
        @RequestHeader("Referer") String referer, @RequestHeader("User-Agent") String user_agent) {
        
            Map<String, Object> map = new HashMap<>();
            map.put("Referer", referer);
            map.put("user_agent", user_agent);
            return map;
    }

    // localhost:8080/api/v1/get/variable/...
    @GetMapping("variable1/{param}")
    public String getVariable1(@PathVariable String param) {
        return param;
    }
    
    @GetMapping("variable2/{param}")
    public String getVariable2(@PathVariable("param") String variable) {
        return variable;
    }

    @GetMapping("variable3/{param1}/{param2}")
    public String getVariable3(@PathVariable String param1, @PathVariable String param2) {
        return param1 + " / " + param2;
    }

    // localhost:8080/api/v1/get/query1?name=hi
    @GetMapping("/query1")
    public String getQuery1(@RequestParam String name) {
        return name;
    }

    // localhost:8080/api/v1/get/query2?name=name1&email=sample@gmail.com
    @GetMapping("/query2")
    public String getQuery2(@RequestParam String name, @RequestParam String email) {
        return name + " / " + email;
    }

    @GetMapping("{param}/query3")
    public String getVarQue(@PathVariable String param, @RequestParam String name) {
        return param + " / " + name;
    }

    // localhost:8080/api/v1/get/query3/hello/world?name=name1&email=sample@gmail.com -> name, email 정의
    @GetMapping("/query3/{param1}/{param2}")
    public String getQuery3(
        @PathVariable String param1, @PathVariable String param2,
        @RequestParam String name, @RequestParam String email) {
        return param1 + " / " + param2 + "/ " + name + " / " + email;
    }


    // localhost:8080/api/v1/get/query4?name=name1&email=sample@gmail.com&age=33
    @GetMapping("/query4")
    public String getQuery4(@RequestParam Map<String, Object> params) { // 쿼리문의 파라미터를 사전에 정의하지 않고도 여러 개 받아올 수 있다.
        log.info("[ControllerGet][getQuery4] Start");
        params.forEach((strKey, strValue)->{
            // System.out.println(strKey + strValue);
            log.info("[getQuery4] " + strKey + " : " + strValue);
        }); 
        return "getQuery4";
    }

    @GetMapping("/query5")
    public String getQuery5(@ModelAttribute UserDto dto) { // ModelAttribute: get과 set을 통해 가져옴
        log.info("[ControllerGet][getQuery5] Start");
        
        log.info("name: " + dto.getName());
        log.info("email: " + dto.getEmail());
        log.info("age: " + dto.getAge());
        return "getQuery5";
    }
    
    @GetMapping("/query6")
    public String getQuery6(@ModelAttribute User1Dto dto) { // ModelAttribute: get과 set을 통해 가져옴
        log.info("[ControllerGet][getQuery6] Start");
        
        log.info(dto.toString());
        return "getQuery6";
    }

    @GetMapping("/query7")
    public String getQuery7(@ModelAttribute User2Dto dto) { // ModelAttribute: get과 set을 통해 가져옴
        log.info("[ControllerGet][getQuery7] Start");
        
        log.info(dto.toString());
        return "getQuery7";
    }
}
