package com.company.Book.Invenory.service;

import com.company.Book.Invenory.dao.BookDAO;
import com.company.Book.Invenory.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.util.List;


public class GetBooksService {

    //@Autowired

    private static final BookDAO bookDAO = new BookDAO();

    private static EntityManager entityManager = bookDAO.getEntityManager();


    public static List<Book> getAllBooksByIndexes() {
        List<Book> allBooks = null;
        try {
            bookDAO.beginTransaction();
            allBooks = entityManager.createQuery("from Book").getResultList();
        } finally {
            bookDAO.commitTransaction();
        }
        return allBooks;
    }

//    private static final SessionFactory sessionFactory = bookDAO.SessionFactory();
//    private static final Session session = sessionFactory.getCurrentSession();
//
//
//    public static List<Book> getAllBooksByIndexes() {
//        List<Book> allBooks = null;
//        try {
//            session.beginTransaction();
//            allBooks = session.createQuery("from Book").list();
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }
//        return allBooks;
//    }

}
