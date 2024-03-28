package com.example.nosecurity.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoginMsg {
    NO_USERID("사용자 없음 / 신규가입 필요"),
    NO_MATCH_PW("비밀번호 재입력");

    private String msg;
}
