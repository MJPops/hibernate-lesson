package com.hiber;

import com.hiber.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateLesson {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()){
            session.beginTransaction();

            User user = User.builder()
                    .username("sasha@gmail.com")
                    .firstname("sasha")
                    .lastname("ushankov")
                    .birthDate(LocalDate.of(2003, 3, 16))
                    .age(18)
                    .build();
            session.save(user);

            session.getTransaction().commit();
        }
    }
}
