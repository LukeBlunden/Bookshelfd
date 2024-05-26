package com.example.Bookshelfd.repositories;

import com.example.Bookshelfd.entities.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long> {

    // Gets all books from DB that match user ID
    @Query(value = "SELECT * FROM books WHERE user_id = ?1", nativeQuery = true)
    List<Book> findByUserId(Long userId);

    // Gets read status of book from DB that matches volume and user ID
    @Query(value = "SELECT read_status FROM books WHERE volume_id = :volumeId AND user_id = :userId", nativeQuery = true)
    Boolean findReadStatus(@Param("volumeId") String volumeId, @Param("userId") Long userId);

    // Gets book from DB that matches volume and user ID
    @Query(value = "SELECT * FROM books b WHERE volume_id = :volumeId AND user_id = :userId", nativeQuery = true)
    Book findByVolumeIdAndUserId(@Param("volumeId") String volumeId, @Param("userId") Long userId);

    // Deletes book from DB that matches volume and user ID
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM books WHERE volume_id = :volumeId AND user_id = :userId", nativeQuery = true)
    void deleteByVolumeIdAndUserId(@Param("volumeId") String volumeId, @Param("userId") Long userId);
}
