package com.example.backend.service;

import com.example.backend.data.Book;
import com.example.backend.exception.BookNotFoundException;
import com.example.backend.repository.BooksRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BooksService {

    private BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


    @PostConstruct
    private void initData() {
        List<Book> books = List.of(new Book().withId(1L).withName("Iliad"), new Book().withId(2L).withName("Histories"),
                new Book().withId(3L).withName("Legend"), new Book().withId(4L).withName("Shield of Thunder"));
        booksRepository.saveAll(books);
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

    public Book addBook(Book book) {
        return booksRepository.save(book);
    }
}
