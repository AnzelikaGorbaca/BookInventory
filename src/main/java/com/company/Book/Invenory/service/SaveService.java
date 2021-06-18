package com.company.Book.Invenory.service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SaveService {

    @Autowired
    SessionFactory sessionFactory;

    Session session = sessionFactory.getCurrentSession();

}
