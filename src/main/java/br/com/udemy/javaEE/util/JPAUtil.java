package br.com.udemy.javaEE.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    // O EntityManagerFactory recebe como parâmetro o nome atribuido ao persistence-unit, para que ele identifique qual BD será utilizado
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("course-jpa");

    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}
