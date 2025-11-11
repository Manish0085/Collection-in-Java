package com.paypal;

import jakarta.persistence.EntityManager;

public class JPADemoMain {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            UserClassHibernate user = new UserClassHibernate("Alice", "alice@example.com");
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            System.out.println("User Saved: "+user.getId());
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            em.close();
            JPAUtil.close();
        }
    }
}
