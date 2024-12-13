package br.com.udemy.javaEE.application;

import br.com.udemy.javaEE.entities.Person;
import br.com.udemy.javaEE.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class Program
{
    public static void main( String[] args ) {

        EntityManager em = JPAUtil.getEntityManager();

        Person p1 = new Person(null, "Carlos da Silva", "carlos@gmail.com");
        Person p2 = new Person(null, "Joaquim Torres", "joaquim@gmail.com");
        Person p3 = new Person(null, "Ana Maria", "ana@gmail.com");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        em.getTransaction().begin();

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        // Operações de consultas são as únicas que não precisam de transação
        // É possível realizar operações de consulta, tanto em estado `Detached`, quanto em `Managed`
        Person person = em.find(Person.class, 2);

        em.remove(person);

        em.getTransaction().commit();

        em.close();

        System.out.println("Done!");

    }
}
