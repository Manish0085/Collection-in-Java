package com.paypal;

import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();

        try {
            UserClassHibernate user = new UserClassHibernate("Bob", "bob@eample.com");
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
            System.out.println("User saved: " + user.getId());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
           HibernateUtil.close();
        }
    }

}