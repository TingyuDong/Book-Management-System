package com.example.backend.service;

import com.example.backend.data.Book;
import com.example.backend.repository.BooksRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BooksServiceTest {

    @Mock
    BooksRepository booksRepository;

    @Test
    public void getBookById() {

        BooksService booksService = new BooksService(booksRepository);

        Optional<Book> book = Optional.of(new Book().withId(1L).withName("Iliad"));

        when(booksRepository.findById(1L)).thenReturn(book);

        Book foundBook = booksService.findById(1L);

        assertThat(foundBook).isEqualTo(book.get());

        verify(booksRepository).findById(1L);
    }


}
