package com.company.Book.Invenory.model;

import lombok.Data;
import lombok.Generated;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table (name = "book")
//@Generated //doesn't work
//@Data//doesn't work
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int id;
    @NotEmpty(message = "Name should not to be empty")
    @Size(min = 1, max = 40, message = "Name should be between 1 and 40 characters")
    private String title;

    @NotEmpty(message = "Author should not be empty")
    private String author;

    @Min(value = 1000, message = "Year should not be valid")
    @Max(value = 2022 , message = "Year should not be valid")
    private int year;

    @Min(value = 1, message = "There should be at least 1 page")
    private int pages;

    @NotEmpty(message = "Language should not to be empty")
    private String language;

    @NotEmpty(message = "Description should not to be empty")
    @Size(min = 1, max = 250, message = "Maximum is 250 characters")
    private String description;



    public Book() {

    }

    public Book(int id, @NotEmpty(message = "Name should not to be empty") @Size(min = 1, max = 40, message = "Title should be between 1 and 40 characters") String title, @NotEmpty(message = "Author should not be empty") String author, @NotEmpty(message = "Year should not to be empty") int year, @NotEmpty(message = "Pages should not to be empty") @Size(min = 1, message = "There should be at least 1 page") int pages, @NotEmpty(message = "Language should not to be empty") String language, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.language = language;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

