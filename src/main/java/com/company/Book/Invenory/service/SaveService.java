package com.company.Book.Invenory.service;

import com.company.Book.Invenory.dao.BookDAO;
import com.company.Book.Invenory.model.Book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class SaveService {


    private static BookDAO bookDAO = new BookDAO();

    private static final SessionFactory sessionFactory = bookDAO.SessionFactory();
    private static final Session session = sessionFactory.getCurrentSession();


    public static void save(Book book) {
        try {
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }


    }
}