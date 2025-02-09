package com.example.Library_management.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "history")
    List<User> user;

    @OneToMany(mappedBy = "history")
    List<Book> book;

}
