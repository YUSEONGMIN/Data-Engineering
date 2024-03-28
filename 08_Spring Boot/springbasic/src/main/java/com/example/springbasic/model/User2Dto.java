package com.example.springbasic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // 선언만 해도 lombok의 기본생성 함수 생성
@AllArgsConstructor // 전체를 input으로 받는 생성 함수
@Getter
@Setter
@ToString

public class User2Dto {
    private String name;
    private String email;
    private int age;
}
