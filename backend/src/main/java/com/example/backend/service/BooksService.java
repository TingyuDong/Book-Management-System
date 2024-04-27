package com.example.backend.service;

import com.example.backend.data.Book;
import com.example.backend.exception.BookNotFoundException;
import com.example.backend.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BooksService {

    private BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


    public Book findById(long id) throws BookNotFoundException {
        Optional<Book> oBook = booksRepository.findById(id);
        if (oBook.isPresent()) {
            return oBook.get();
        } else {
            throw new BookNotFoundException();
        }
    }

    public List<Book> findAll() {
        Iterable<Book> booksIterable = booksRepository.findAll();
        return StreamSupport.stream(booksIterable.spliterator(), false).collect(Collectors.toList());
    }
}
