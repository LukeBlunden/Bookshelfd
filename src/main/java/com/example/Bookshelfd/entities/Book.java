package com.example.Bookshelfd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "books")
@Table(name = "books")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "userId", nullable = false, columnDefinition = "BIGINT")
    private Long userId;
    @Column(name = "volumeId", nullable = false, columnDefinition = "TEXT")
    private String volumeId;
    @Column(name = "readStatus", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean readStatus;

    public Book(Long userId, String volumeId, Boolean readStatus) {
        this.userId = userId;
        this.volumeId = volumeId;
        this.readStatus = readStatus;
    }
}
