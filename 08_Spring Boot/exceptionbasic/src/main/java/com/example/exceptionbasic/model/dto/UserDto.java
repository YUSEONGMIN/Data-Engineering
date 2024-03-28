package com.example.exceptionbasic.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity // 엔티티 폴더를 따로 만들지 않고 한번에
@Table(name = "user")
public class UserDto {

    @Id
    @NotBlank
    private String userId;
    @NotBlank
    private String userPw;
    @PositiveOrZero
    @Max(value = 100)
    private int userAge;
    @Email
    private String userEmail;

    // enum에 대해서

    @NotBlank
    private String userType; // 일반 사용자, 관리자, 매니저
    // 아무 값이나 들어갈 수 있어서 서비스에서 처리
}
