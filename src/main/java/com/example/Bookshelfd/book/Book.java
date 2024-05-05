package com.example.Bookshelfd.book;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

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
    private Long id;
    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String title;
    @Column(name = "authors", nullable = false, columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> authors;
    @Column(name = "cover", nullable = false, columnDefinition = "TEXT")
    private String cover;
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(name = "publishedDate", nullable = false)
    private String publishedDate;
    @Column(name = "printType", nullable = false, columnDefinition = "TEXT")
    private String printType;
    @Column(name = "categories", nullable = false, columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> categories;


    public Book() {
    }

    public Book(Long id, String title, List<String> authors, String cover, String description, String publishedDate, String printType, List<String> categories) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.cover = cover;
        this.description = description;
        this.publishedDate = publishedDate;
        this.printType = printType;
        this.categories = categories;
    }

    public Book(String title, List<String> authors, String cover, String description, String publishedDate, String printType, List<String> categories) {
        this.title = title;
        this.authors = authors;
        this.cover = cover;
        this.description = description;
        this.publishedDate = publishedDate;
        this.printType = printType;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
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

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }


}
