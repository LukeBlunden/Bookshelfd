package com.example.Bookshelfd.book;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
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
    private long id;
    private String name;
    private String author;
    private String cover;
    private String description;
    private Integer published;

    public Book() {
    }

    public Book(String name, String author, String cover, String description, Integer published) {
        this.name = name;
        this.author = author;
        this.cover = cover;
        this.description = description;
        this.published = published;
    }

    public Book(long id, String name, String author, String cover, String description, Integer published) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.cover = cover;
        this.description = description;
        this.published = published;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPublished() {
        return published;
    }

    public void setPublished(Integer published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", cover='" + cover + '\'' +
                ", description='" + description + '\'' +
                ", published=" + published +
                '}';
    }
}
