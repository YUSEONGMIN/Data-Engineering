package com.example.validation.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// validation을 적용한 dto
// 유효성 검사
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserValiDto {
    // Id는 무조건 들어가야 함 NotBlank
    @NotBlank // null, "", " " 불가능
    private String id;
    @NotNull // null 불가능
    private String name;
    @NotEmpty // null, "" 불가능
    private String password;
    // @Size(min = 4, max = 100) // 또는
    @PositiveOrZero // 양수 이면서
    @Max(value = 100) // 최대 100살까지
    private int age;
    @Email // email 형태 검증 ...@...com
    private String email;
    // 010, 011, 016, ... - 123 또는 1234 - 1234
    @Pattern(regexp="^01(?:0|1|[6-9])-?\\d{3,4}-?\\d{4}$", message = "올바른 전화번호를 입력해주세요.")
    private String phoneNumber;
// if문을 쓰지않아도 어노테이션(@)을 쓰면 간단하게 처리 가능
}
