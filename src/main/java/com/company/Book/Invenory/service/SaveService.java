package com.company.Book.Invenory.service;

import com.company.Book.Invenory.dao.BookDAO;
import com.company.Book.Invenory.model.Book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;


public class SaveService {



    private static final BookDAO bookDAO = new BookDAO();


    private static final EntityManager entityManager = bookDAO.getEntityManager();

    public static void save(Book book){
        try {
            bookDAO.beginTransaction();
            entityManager.persist(book);
        } finally {
            bookDAO.commitTransaction();
        }

    }



//    public static void save(Book book) {
//        try {
//            session.beginTransaction();
//            session.save(book);
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }
//
//
//    }
}