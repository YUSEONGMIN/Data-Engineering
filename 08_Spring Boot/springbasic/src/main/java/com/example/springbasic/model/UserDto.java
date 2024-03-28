package com.example.springbasic.model;

public class UserDto { // DTO로 가져오기
    private String name;
    private String email;
    private int age;

    public UserDto() {}
    public UserDto(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public void setName(String name) { // 수정을 할 땐 Set
        this.name = name;
    }
    public String getName() { // 가져올 땐 Get. Camel 표기법
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
}
