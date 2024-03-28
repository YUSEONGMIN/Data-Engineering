package com.example.springbasic.model;

public class User1Dto {
    private String name;
    private String email;
    private int age;

    // Ctrl + . = Source Action
    // generate Constructors
    public User1Dto() {
    }

    public User1Dto(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // get set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString: 자동으로 하나의 string으로 return -> 한번에 내용 확인
    @Override
    public String toString() {
        return "User1Dto [name=" + name + ", email=" + email + ", age=" + age + "]";
    }
}