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

    // Adds book for user to DB
    public Book addBook(Book book) {
        // Checks if book already exists for that user
        Book existingBook = bookRepository.findByVolumeIdAndUserId(book.getVolumeId(), book.getUserId());
        // If that book does exist, and if the reading status is different, updates the read status
        if (existingBook != null && book.getReadStatus() != existingBook.getReadStatus()) {
            existingBook.setReadStatus(!existingBook.getReadStatus());
            book = existingBook;
        }
        // Saves book
        return bookRepository.save(book);
    }

    public List<Book> findByUserId(Long userId) { return bookRepository.findByUserId(userId);}

    public Boolean findReadStatus(String volumeId, Long userId) { return bookRepository.findReadStatus(volumeId, userId); }

    public void deleteBook(String volumeId, Long userId) { bookRepository.deleteByVolumeIdAndUserId(volumeId, userId);}
}
