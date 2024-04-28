package com.example.backend.controller;

import com.example.backend.data.Book;
import com.example.backend.service.BooksService;
import org.springframework.web.bind.annotation.*;

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
        return List.of(new Book().withId(1L).withName("Iliad"), new Book().withId(2L).withName("Histories"), new Book().withId(2L).withName("Legend"), new Book().withId(2L).withName("Shield of Thunder"));
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return booksService.addBook(book);
    }
}
