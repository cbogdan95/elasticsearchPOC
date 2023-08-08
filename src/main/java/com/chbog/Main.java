package com.chbog;

import com.chbog.entities.Company;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        Company company = new Company();
        company.setName("Test Company");

        em.getTransaction().begin();
        em.persist(company);
        em.getTransaction().commit();

        Company c = em.find(Company.class, company.getId());
        System.out.println(c.getName());

        em.close();
        emf.close();
    }
}