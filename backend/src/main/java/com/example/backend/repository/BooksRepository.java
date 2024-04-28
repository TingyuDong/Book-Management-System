package com.example.backend.repository;

import com.example.backend.data.Book;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Book, Long> {
}
