package com.example.backend.service;

import com.example.backend.data.Book;
import com.example.backend.exception.BookNotFoundException;
import com.example.backend.repository.BooksRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BooksServiceTest {

    @Mock
    BooksRepository booksRepository;

    @Test
    public void getBookById() throws BookNotFoundException {
        BooksService booksService = new BooksService(booksRepository);
        Optional<Book> book = Optional.of(new Book().withId(1L).withName("Iliad"));

        when(booksRepository.findById(1L)).thenReturn(book);
        Book foundBook = booksService.findById(1L);

        assertThat(foundBook).isEqualTo(book.get());
        verify(booksRepository).findById(1L);
    }

    @Test
    public void getAllBook() {
        BooksService booksService = new BooksService(booksRepository);
        List<Book> books = List.of(new Book().withId(1L).withName("Iliad"), new Book().withId(2L).withName("Histories"));

        when(booksRepository.findAll()).thenReturn(books);
        List<Book> foundBooks = booksService.findAll();

        assertThat(foundBooks).isEqualTo(books);
        verify(booksRepository).findAll();
    }

    @Test
    public void addBook() {
        BooksService booksService = new BooksService(booksRepository);
        Book book = new Book().withId(1L).withName("Iliad");

        when(booksRepository.save(any(Book.class))).thenReturn(book);
        Book addBooks = booksService.addBook(book);

        assertThat(addBooks).isEqualTo(book);
        verify(booksRepository).save(book);
    }

}
