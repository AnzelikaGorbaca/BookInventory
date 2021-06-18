package com.company.Book.Invenory.service;

import com.company.Book.Invenory.dao.BookDAO;
import com.company.Book.Invenory.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateService {

    private static BookDAO bookDAO = new BookDAO();

    private static final SessionFactory sessionFactory = bookDAO.SessionFactory();
    private static final Session session = sessionFactory.getCurrentSession();


    public static void update(int id, Book book) {
        try {
            session.beginTransaction();
            Book bookNeedToUpdated = (Book)session.load(Book.class,id);
            bookNeedToUpdated.setTitle(book.getTitle());
            bookNeedToUpdated.setAuthor(book.getAuthor());
            bookNeedToUpdated.setYear(book.getYear());
            bookNeedToUpdated.setLanguage(book.getLanguage());
            bookNeedToUpdated.setPages(book.getPages());
            bookNeedToUpdated.setDescription(book.getDescription());
            session.update(bookNeedToUpdated);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
