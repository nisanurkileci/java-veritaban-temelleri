package org.example;

import org.hibernate.Session;
import util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Hibernate bağlantısı başarılı!");
        session.close();

        HibernateUtil.shutdown();
    }
}
