package com.example.Bookshelfd.repositories;

import com.example.Bookshelfd.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long> {

//    @Query("Select b FROM Book b WHERE b.author = ?1")
//    Optional<Book> findBookByAuthor(String author);
}
