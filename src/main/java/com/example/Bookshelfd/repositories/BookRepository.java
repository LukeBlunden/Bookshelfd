package com.example.Bookshelfd.repositories;

import com.example.Bookshelfd.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long> {

//    @Query("Select b FROM Book b WHERE b.author = ?1")
//    Optional<Book> findBookByAuthor(String author);

    @Query(value = "SELECT * FROM books WHERE user_id = ?1", nativeQuery = true)
    List<Book> findByUserId(Long userId);

    @Query(value = "SELECT read_status FROM books WHERE volume_id = :volumeId AND user_id = :userId", nativeQuery = true)
    Boolean findReadStatus(@Param("volumeId") String volumeId, @Param("userId") Long userId);

    @Query(value = "SELECT * FROM books b WHERE volume_id = :volumeId AND user_id = :userId", nativeQuery = true)
    Book findByVolumeIdAndUserId(@Param("volumeId") String volumeId, @Param("userId") Long userId);
}
