package com.example.nosecurity.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    GENERAL("일반 사용자"),
    ADMIN("관리자");

    private final String userRoleMsg;
}
