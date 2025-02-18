package com.example.Library_management.service.books;

import com.example.Library_management.exception.ResourceNotFoundException;
import com.example.Library_management.model.books.Book;
import com.example.Library_management.repository.books.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    //図書一覧取得
    public List<Book> getBookAll(){
        return bookRepository.findAll();
    }

    //図書をid毎に取得
    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    //図書登録
    public Book createBook(Book bookForm){
        return bookRepository.save(bookForm);
    }

    //図書更新
    public Book editBook(Book bookForm, Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found" + id));
        book.setTitle(bookForm.getTitle());
        book.setCategory(bookForm.getCategory());
        book.setAuthor(bookForm.getAuthor());
        book.setStock(bookForm.getStock());
        bookRepository.save(book);
        return book;
    }

    //図書削除
    public Book deleteBook(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found" + id));
        bookRepository.delete(book);
        return book;
    }


}
