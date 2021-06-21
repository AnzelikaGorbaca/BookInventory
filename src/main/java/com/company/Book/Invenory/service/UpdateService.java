package com.company.Book.Invenory.service;

import com.company.Book.Invenory.dao.BookDAO;
import com.company.Book.Invenory.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

public class UpdateService {

    private static final BookDAO bookDAO = new BookDAO();

    private static final EntityManager entityManager = bookDAO.getEntityManager();


    public static void update(int id, Book book) {
        try {

            bookDAO.beginTransaction();
            Book bookNeedToUpdated = entityManager.find(Book.class, id);
            bookNeedToUpdated.setTitle(book.getTitle());
            bookNeedToUpdated.setAuthor(book.getAuthor());
            bookNeedToUpdated.setYear(book.getYear());
            bookNeedToUpdated.setLanguage(book.getLanguage());
            bookNeedToUpdated.setPages(book.getPages());
            bookNeedToUpdated.setDescription(book.getDescription());
            entityManager.merge(bookNeedToUpdated);


        } finally {
            bookDAO.commitTransaction();


        }

    }
}
