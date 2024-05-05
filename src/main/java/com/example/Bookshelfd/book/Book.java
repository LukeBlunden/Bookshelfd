package com.example.Bookshelfd.book;

import jakarta.persistence.*;

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
    private String id;
    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String title;
    @Column(name = "author", nullable = false, columnDefinition = "TEXT")
    private String[] authors;
    @Column(name = "cover", nullable = false, columnDefinition = "TEXT")
    private String cover;
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(name = "publishedDate", nullable = false)
    private String publishedDate;
    @Column(name = "printType", nullable = false, columnDefinition = "TEXT")
    private String printType;
    @Column(name = "categories", nullable = false, columnDefinition = "TEXT")
    private String[] categories;
//    Probably should include ISBN, check API's for type


    public Book() {
    }

    public Book(String id, String title, String[] authors, String cover, String description, String publishedDate, String printType, String[] categories) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.cover = cover;
        this.description = description;
        this.publishedDate = publishedDate;
        this.printType = printType;
        this.categories = categories;
    }

    public Book(String title, String[] authors, String cover, String description, String publishedDate, String printType, String[] categories) {
        this.title = title;
        this.authors = authors;
        this.cover = cover;
        this.description = description;
        this.publishedDate = publishedDate;
        this.printType = printType;
        this.categories = categories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
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

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }


}
