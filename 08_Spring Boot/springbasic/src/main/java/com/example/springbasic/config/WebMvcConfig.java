package com.example.springbasic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.springbasic.config.interceptor.BasicInterceptor;

// 스프링은 2개의 디자인 패턴을 이용해 프레임워크 만듦
// MVC 디자인 패턴: new 하지 않아도 @(어노테이션)하면 객체로 만들어줌 (커피빈)
// 싱글톤 패턴: 1개의 클래스에서 1개의 객체를 만들어서 재사용 (메모리 문제) -> 없으면 만들고, 있으면 있는걸로 가져다가 사용. 만들어진 것 하나만 사용
//         registry.addInterceptor(new BasicInterceptor())
// new BasicInterceptor() -> 객체가 2개가 생성되는 문제 발생 -> @ 빼던가 new 빼던가

// 빈을 등록할 때 일반 빈이 아닌 설정을 할 수 있는 전용 config 빈 등록
@Configuration // 설정 조작
public class WebMvcConfig implements WebMvcConfigurer{
    // WebMvcConfigurer: 스프링 프레임워크 설정 관리 객체

    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    //     // TODO Auto-generated method stub
    //     registry.addInterceptor(new BasicInterceptor())
    //     // .addPathPatterns("/*") // 일반 화면은 다 적용하고 (전체 적용)
    //     // .excludePathPatterns("/addmin/*"); // admin으로 시작하는 것은 제외 (제외하고 싶은 패턴이 있다면)
    //     .addPathPatterns("/api/v1/get/*") // 적용할 url 패턴
    //     .excludePathPatterns("/api/v1/post/*"); // 제외할 url 패턴

    @Lazy
    @Autowired // 존재하면 자동으로 연결해주는 @
    // 만들어진 객체가 있어야 적용. BasicInterceptor.java가 만들어지기 전에 하면 X
    private BasicInterceptor basicInterceptor;

    @SuppressWarnings("null")
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        registry.addInterceptor(basicInterceptor)
        .addPathPatterns("/api/v1/get/*")
        .excludePathPatterns("/api/v1/post/*");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
// 기존 인터셉터에 내가 만든 인터셉터 추가
