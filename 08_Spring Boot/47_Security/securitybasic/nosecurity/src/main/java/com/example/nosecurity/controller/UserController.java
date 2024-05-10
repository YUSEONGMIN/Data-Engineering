package com.example.nosecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.nosecurity.model.dto.UserDto;
import com.example.nosecurity.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

// 화면 개발은 UserController에서. 로그인은 ApiUserController
@Slf4j
@Controller
@RequestMapping("/v1/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    // 누구나 접속이 가능한 index 화면
    @GetMapping("/index")
    public String index() {
        log.info("[UserController][index] Start:");
        return "index";
    }

     // join 화면
    @GetMapping("/joinPage")
    public String joinPage() {
    return "join";
    }

    // join 요청
    @PostMapping("/join")
    public String join(@Valid @ModelAttribute UserDto dto) throws Exception {
        log.info("[UserController][join] dto:" + dto.toString());
        userService.joinUser(dto);
        return "redirect:/v1/user/loginPage";
    }

    //  login 화면
    @GetMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    // login 요청 -> 성공하면 가입자 화면
    // HttpServletRequest: session 객체에 로그인 성공 정보 담기
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute UserDto dto, HttpServletRequest request) throws Exception {
        UserDto user = userService.loginUser(dto);
        if (user == null) { // id 조회를 했는데 null이라면 미가입자
            return "redirect:/v1/user/joinPage";
        } else if (user.getUserRole() == null || user.getUserEmail() == null) {
            return "redirect:/v1/user/loginPage";
        }

        // 로그인 성공
        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getUserId()); // 인증에 대한 정보
        session.setAttribute("userRole", user.getUserRole()); // 인가에 대한 정보

        return "redirect:/v1/user/userPage";
    }

    // login 성공한 접속 화면
    @GetMapping("/userPage")
    public String userPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        // 인증에 대한 정보
        if (session.getAttribute("userId") == null) {
            return "redirect:/v1/user/loginPage";
        }
    
        model.addAttribute("userId", session.getAttribute("userId"));
        if (session.getAttribute("userId").equals("ADMIN")) {
            model.addAttribute("admin", true);
        }

        return "user";
    }

    // login 성공 및 관리자 권한이 있는 접속 화면
    @GetMapping("/adminPage")
    public String adminPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        // 인증에 대한 정보
        if (session.getAttribute("userId") == null) {
            return "redirect:/v1/user/loginPage";
        // 인가에 대한 정보
        } else if (!session.getAttribute("userRole").equals("ADMIN")) {
            return "redirect:/v1/user/userPage";
        }

        model.addAttribute("userId", session.getAttribute("userId"));
        return "admin";
    }

    // 로그아웃 -> login 화면
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("userId");
        session.removeAttribute("userRole");

        return "redirect:/v1/user/loginPage";
    }
};
