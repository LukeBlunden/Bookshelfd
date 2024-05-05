package com.example.Bookshelfd.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long> {

//    @Query("Select b FROM Book b WHERE b.author = ?1")
//    Optional<Book> findBookByAuthor(String author);
}
