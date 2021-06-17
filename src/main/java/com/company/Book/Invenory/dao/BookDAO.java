package com.company.Book.Invenory.dao;

import com.company.Book.Invenory.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Component
public class BookDAO {

    //    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public BookDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
    private List<Book> books = new ArrayList<>();
    {
        books.add(new Book(1, "Dance", "Robbie Williams", 2005, 250, "english", "no description"));
        books.add(new Book(2, "Fancy", "Mark Twen", 1988, 455, "english", "no description"));
    }

    public List<Book> index() {

        return books;
    }

    public Book show(int id) {
        return books.stream().filter(b -> b.getId() == id).findAny().orElse(null);
    }

    public void save(Book book) {
        books.add (book);
    }

    public void update(int id, Book updatedBook) {
        Book needToUpdate = show(id);

        needToUpdate.setTitle(updatedBook.getTitle());
        needToUpdate.setAuthor(updatedBook.getAuthor());
        needToUpdate.setYear(updatedBook.getYear());
        needToUpdate.setPages(updatedBook.getPages());
    }

    public void delete(int id) {
        books.removeIf(b -> b.getId() == id);

    }
}