package com.example.mustachebasic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mustachebasic.model.BookDto;

// 이 컨트롤러는 데이터와 화면을 같이 머스태치에게 전달. 이후 머스태치는 그 두개를 가지고 html을 만들고 클라이언트에게 전달
@Controller
@RequestMapping("/v1/book") // api와는 달리 화면도 같이 제공
public class BookController {
    
    @GetMapping("/hello")
    public String getHello(Model model) {
        // 일반 텍스트
        model.addAttribute("name", "홍길동");
        // model.addAttribute("company", "Google");

        // 일반 텍스트 > html 문법 텍스트
        model.addAttribute("company", "<h3>Google</h3>");

        // boolean
        // model.addAttribute("person", false);
        model.addAttribute("person", true);

        return "Hello"; // <- 화면. templates 폴더에 Hello 라는 파일이 있으면 그 화면을 이용
    }

    @GetMapping("/one")
    public String getBook(Model model) {

        // 가정: db 데이터 한개 조회함
        BookDto dto = new BookDto();
        dto.setBookId((long)1);
        dto.setBookTitle("책 제목");
        dto.setIsbn(false);
        dto.setAuthor("홍길동");
        dto.setPrice((double)10000);
        // model.addAttribute("dto", dto); // dto 라는 객체를 전달
        model.addAttribute("book", dto);

        return "book";
    }

    @GetMapping("/list")
    public String getBookList(Model model) {

        List<BookDto> bookList = new ArrayList<BookDto>();
        for(int i=0; i<5; i++) {
            BookDto book = new BookDto(
                (long) i, (i < 3) ? true:false, "Book Name" + i, "Author: " + i, (double)20*i + 100);
            bookList.add(book);
        }
        
        model.addAttribute("bookList", bookList);
        return "bookList";
    }
}
