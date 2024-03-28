package com.example.exceptionbasic.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

// enum : 상수 느낌 -> common, constant, static 등

@Getter
@AllArgsConstructor
public enum ProductTypeConstant {
    
    TV("tv", "텔레비전입니다."),
    PC("pc","컴퓨터입니다."),
    PHONE("phone", "전화기입니다."); // 상수는 보통 대문자

    private final String productType;
    private final String productMsg;

    // DB에 저장할 때는 productType만 저장. Msg는 사용자 마음
}
