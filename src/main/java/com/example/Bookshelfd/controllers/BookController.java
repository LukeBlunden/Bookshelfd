package com.example.Bookshelfd.controllers;

import com.example.Bookshelfd.dtos.AddBookDto;
import com.example.Bookshelfd.entities.Book;
import com.example.Bookshelfd.entities.User;
import com.example.Bookshelfd.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Book>> findAllBooks() {
        List<Book> books = bookService.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Book> addBook(@RequestBody AddBookDto book, @AuthenticationPrincipal User user) {
        Long userId = user.getId();
        Book newBook = bookService.addBook(new Book(userId, book.volumeId(), book.readStatus()));
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @GetMapping(path = "/userBooks")
    public ResponseEntity<List<Book>> findByUserId(@AuthenticationPrincipal User user) {
        Long userId = user.getId();
        List<Book> books = bookService.findByUserId(userId);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(path = "/readStatus/{volumeId}")
    public ResponseEntity<Boolean> getReadStatus(@PathVariable("volumeId") String volumeId, @AuthenticationPrincipal User user) {
        Long userId = user.getId();
        System.out.println(volumeId);
        System.out.println(userId);
        Boolean readStatus = bookService.findReadStatus(volumeId, userId);
        System.out.println(readStatus);
        return new ResponseEntity<>(readStatus, HttpStatus.OK);
    }
}
