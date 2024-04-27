package com.example.backend.data;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@With
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    private Long id;

    private String name;

    private String author;

    private String publicationYear;

    private String isbn;

    private boolean isDeleted;
}
