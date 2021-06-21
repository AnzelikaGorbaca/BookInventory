package com.company.Book.Invenory.service;

import com.company.Book.Invenory.dao.BookDAO;
import com.company.Book.Invenory.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

public class DeleteService {

    private static final BookDAO bookDAO = new BookDAO();


    private static final EntityManager entityManager = bookDAO.getEntityManager();

    public static void delete(int id) {
        try {
            bookDAO.beginTransaction();
            Book bookNeedToDelete = entityManager.find(Book.class,id);;
            entityManager.remove(bookNeedToDelete);
        } finally {
            bookDAO.commitTransaction();
        }

    }
}
