package com.example.backend.controller;

import com.example.backend.data.Book;
import com.example.backend.exception.BookNotFoundException;
import com.example.backend.service.BooksService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BooksController.class)
public class BooksControllerTest {
    @MockBean
    BooksService booksService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetById() throws Exception {
        Book book = new Book().withId(1L).withName("Iliad");

        when(booksService.findById(1L)).thenReturn(book);

        mockMvc.perform(get("/books/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Iliad"));

        verify(booksService).findById(1);

    }

    @Test
    public void testGetByIdNotFound() throws Exception {

        when(booksService.findById(1)).thenThrow(new BookNotFoundException());

        mockMvc.perform(get("/books/1")).andExpect(status().isNotFound());

        verify(booksService).findById(1);

    }
}
