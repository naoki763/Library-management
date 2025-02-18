package com.example.Library_management.controller.books;

import com.example.Library_management.model.books.Book;
import com.example.Library_management.service.books.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    //図書を登録する
    @PostMapping("/register")
    public ResponseEntity<String> create(@RequestBody  Book bookForm){
//        System.out.println(bookForm.getTitle());
//        System.out.println(bookForm.getAuthor());
//        System.out.println(bookForm.getCategory());
//        System.out.println(bookForm.getStock());
        Book book = bookService.createBook(bookForm);
        return ResponseEntity.status(200).body("登録が完了しました。");
    }

    //図書の一覧を取得する。
    @GetMapping("/get")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> book = bookService.getBookAll();
        return ResponseEntity.ok(book);
    }

    //図書をid毎に取得する。
    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Book>> getUserById(@PathVariable Long id){
        Optional<Book> book = bookService.getBookById(id);
        return  ResponseEntity.ok(book);
    }

    //図書を更新する
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> edit(@RequestBody Book bookForm, @PathVariable Long id){
        Book book = bookService.editBook(bookForm, id);
        return ResponseEntity.status(200).body("更新が完了しました。");
    }

    //図書を削除する
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable  Long id){
        Book book = bookService.deleteBook(id);
        return ResponseEntity.status(200).body("削除が完了しました");
    }

}
