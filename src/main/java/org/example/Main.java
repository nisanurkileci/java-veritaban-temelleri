package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import user.User;
import util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();


            User user = new User();

            user.setName("hakann");
            user.setEmail("hh@hh.com");

            session.save(user);

            transaction.commit();

            System.out.println("Kullanıcı başarıyla eklendi: " + user);

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
