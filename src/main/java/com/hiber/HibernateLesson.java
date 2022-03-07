package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateLesson {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()){
            System.out.println("Ok");
        }
    }
}
