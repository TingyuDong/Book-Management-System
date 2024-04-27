package com.example.backend.controller;

import com.example.backend.data.Book;
import com.example.backend.service.BooksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable long id) throws Exception {
        return booksService.findById(id);
    }

    @GetMapping
    public List<Book> findAll() {
        return List.of(new Book().withId(1L).withName("Iliad"),new Book().withId(2L).withName("Histories"));
    }
}
