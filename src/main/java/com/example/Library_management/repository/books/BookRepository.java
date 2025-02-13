package com.example.Library_management.repository.books;

import com.example.Library_management.model.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
