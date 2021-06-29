package com.company.Book.Invenory.dao;

import com.company.Book.Invenory.model.Book;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


//@Component
public class BookDAO {

    //@Bean
    public SessionFactory SessionFactory() {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();
        return sessionFactory;

    }


    private EntityManager entityManager = Persistence.createEntityManagerFactory("user-unit").createEntityManager();

    private  EntityTransaction entityTransaction = this.entityManager.getTransaction();

    public EntityManager getEntityManager() {
        return entityManager;
    }


    public void beginTransaction() {
        try {
            entityTransaction.begin();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    public void commitTransaction() {
        try {
            entityTransaction.commit();
            //entityManager.close();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    public void rollbackTransaction() {
        try {
            entityTransaction.rollback();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
