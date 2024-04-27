package com.example.backend.controller;

import com.example.backend.data.Book;
import com.example.backend.service.BooksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

    private BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable long id) {
        return booksService.findById(id);
    }
}
