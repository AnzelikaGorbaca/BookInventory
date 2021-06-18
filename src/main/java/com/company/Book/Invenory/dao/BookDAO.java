package com.company.Book.Invenory.dao;

import com.company.Book.Invenory.model.Book;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.springframework.stereotype.Component;



@Component
public class BookDAO {


    public SessionFactory SessionFactory() {
        SessionFactory sessionFactory = new Configuration()
                .configure() //"hibernate.cfg.xml"
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();
        return sessionFactory;


    }
}