package com.example.Library_management.model.books;

import com.example.Library_management.model.history.History;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private  int stock;

    @OneToMany(mappedBy = "book_id")
    History history;

}
