package com.company.Book.Invenory.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Book {

    private int id;
    @NotEmpty(message = "Name should not to be empty")
    @Size(min = 1, max = 40, message = "Name should be between 1 and 40 characters")
    private String name;

    @NotEmpty(message = "Author should not be empty")
    private String author;

    @NotEmpty(message = "Year should not to be empty")
    private int year;

    @NotEmpty(message = "Pages should not to be empty")
    @Size(min = 1, message = "There should be at least 1 page")
    private int pages;

    @NotEmpty(message = "Language should not to be empty")
    private int language;

    private String description;


}
