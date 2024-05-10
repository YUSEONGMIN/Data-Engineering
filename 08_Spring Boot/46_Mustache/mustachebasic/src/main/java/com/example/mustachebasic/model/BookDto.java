package com.example.mustachebasic.model;

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
public class BookDto {
    private Long bookId;
    private Boolean isbn;
    private String bookTitle;
    private String author;
    private Double price;
}
