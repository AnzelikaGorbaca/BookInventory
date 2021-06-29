package com.company.Book.Invenory.service;

import com.company.Book.Invenory.dao.BookDAO;
import com.company.Book.Invenory.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.util.List;

public class GetByIndexService {


    private static final BookDAO bookDAO = new BookDAO();


    private static EntityManager entityManager = bookDAO.getEntityManager();

    public static Book getBookByIndex(int id){
        Book book = null;
        try {
            bookDAO.beginTransaction();
            book = entityManager.find(Book.class,id);
        } finally {
            bookDAO.commitTransaction();
        }
        return book;
    }



//    private static  final BookDAO bookDAO = new BookDAO();
//
//    private static final SessionFactory sessionFactory = bookDAO.SessionFactory();
//    private static  final Session session = sessionFactory.getCurrentSession();
//    private static final Transaction tx = session.beginTransaction();
//
//    public static Book getBookByIndex(int id) {
//        Book book = null;
//        try {
//            //session.beginTransaction();
//            book =  (Book) session.get(Book.class, id);
//            tx.commit();//session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }
//        return book;
//    }
}
