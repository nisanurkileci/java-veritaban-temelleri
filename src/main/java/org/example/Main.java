package org.example;

import org.hibernate.Session;
import user.User;
import util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User user = new User("Nisa", "nisa@orm.com");
        session.save(user);

        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();

    }
}
