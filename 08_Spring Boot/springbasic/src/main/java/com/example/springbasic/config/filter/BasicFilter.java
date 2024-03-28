package com.example.springbasic.config.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // 일반 객체를 만듦 (객체를 만들어야 사용할 수 있다.)
// Controller Bean은 컨트롤러 객체 만듦
public class BasicFilter implements Filter{ // servlet 필터 상속

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) // Request는 서블릿에 요청. Response는 요청을 처리하기 위함. FilterChain은 여러개 필터
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        log.info("[BasicFilter][doFilter] Start");

        /*
         * filter 로직 작성
         */
        
        // 로직이 완료되면 다음 filter 실행
        chain.doFilter(request, response);
    } 
    
}
