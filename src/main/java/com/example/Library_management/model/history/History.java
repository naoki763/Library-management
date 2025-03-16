package com.example.Library_management.model.history;

import com.example.Library_management.model.books.Book;
import com.example.Library_management.model.users.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Long user_id;

    @ManyToOne
    Long book_id;

    @Column(nullable = false)
    private LocalDateTime create_at;


}
