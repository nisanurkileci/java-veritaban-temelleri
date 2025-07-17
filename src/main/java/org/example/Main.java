package org.example;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import user.User;
import util.HibernateUtil;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Long userIdToUpdate = 1L;
            User userToUpdate = session.get(User.class, userIdToUpdate);

            if (userToUpdate != null) {

                System.out.println("Güncellenecek Kullanıcı (Eski Bilgiler): " + userToUpdate);
                userToUpdate.setName("Güncel Hilal");
                userToUpdate.setEmail("guncel.hh@kk.com");

                transaction.commit();
                System.out.println("Kullanıcı başarıyla güncellendi (Yeni Bilgiler): " + userToUpdate);

            } else {
                System.out.println("ID " + userIdToUpdate + " ile güncellenecek kullanıcı bulunamadı.");

                if (transaction != null) {
                    transaction.rollback();
                }
            }

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }



        /*SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Long userId = 1L;
        User user = session.get(User.class, userId);
        if (user != null) {
            System.out.println("Tek Kayıt -> ID: " + user.getId() + ", Name: " + user.getName());
        } else {
            System.out.println("Kullanıcı bulunamadı.");
        }

        List<User> userList = session.createQuery("from User", User.class).list();
        System.out.println("\nTüm Kullanıcılar:");
        for (User u : userList) {
            System.out.println("ID: " + u.getId() + ", Name: " + u.getName());
        }

        transaction.commit();
        session.close();
        sessionFactory.close();*/
    }

}
