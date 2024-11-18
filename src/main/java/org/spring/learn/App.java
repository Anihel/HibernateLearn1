package org.spring.learn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Collection;
import org.spring.learn.model.Director;
import org.spring.learn.model.Movie;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Director director = new Director("director1", 1996);
            director.addMovie(new Movie("NameMovie2", 2007));
            director.addMovie(new Movie("NameMovie3", 2007));
            director.addMovie(new Movie("NameMovie4", 2007));

            session.persist(director);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }



    }
}
