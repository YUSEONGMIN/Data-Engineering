package com.example.nosecurity.model.dto;

import com.example.nosecurity.common.constant.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
@Entity
@Table(name = "custom")
public class UserDto {
    
    @Id
    @NotBlank
    public String userId;
    @NotBlank
    public String userPassword;
    @Column(unique = true)
    @Email
    private String userEmail;

    // Role: 일반 사용자 또는 관리자 구분
    private String userRole;

    public UserRole checkUserRole() {
        return UserRole.valueOf(this.userRole);
    }

}
