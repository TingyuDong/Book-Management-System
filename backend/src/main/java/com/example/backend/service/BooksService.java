package com.example.backend.service;

import com.example.backend.data.Book;
import com.example.backend.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BooksService {

    private BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


    public Book findById(long id) {
        Optional<Book> oBook = booksRepository.findById(id);
        return oBook.get();
    }
}
