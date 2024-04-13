package com.example.Bookshelfd.book;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "Book")
@Table(name = "book")
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
    private long id;
    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String title;
    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String author;
    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String cover;
    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(name = "title", nullable = false)
    private Date published;
//    Probably should include ISBN, check API's for type


    public Book() {
    }

    public Book(String title, String author, String cover, String description, Date published) {
        this.title = title;
        this.author = author;
        this.cover = cover;
        this.description = description;
        this.published = published;
    }

    public Book(long id, String title, String author, String cover, String description, Date published) {
        this.id = id;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", author='" + author + '\'' +
                ", cover='" + cover + '\'' +
                ", description='" + description + '\'' +
                ", published=" + published +
                '}';
    }
}
