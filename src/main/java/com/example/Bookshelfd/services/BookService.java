package com.example.Bookshelfd.services;

import com.example.Bookshelfd.entities.Book;
import com.example.Bookshelfd.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findByUserId(Long userId) { return bookRepository.findByUserId(userId);}

    public Boolean findReadStatus(String volumeId, Long userId) { return bookRepository.findReadStatus(volumeId, userId); }
}
