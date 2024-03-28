package com.example.validation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//1.  yaml 설정 -> 폴더 3개 생성(컨트롤, 모델, 서비스) -> dto 만들기
// validation이 적용되지 않은 dto
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    private String id;
    private String name;
    private String password;
    private int age;
    private String email;
    private String phoneNumber;

}
