package com.kg.hibernatexml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Employee e1 = new Employee();
        e1.setId(1);
        e1.setFirstName("kannan");      
        e1.setLastName("nila");

    Employee a2= new Employee();
    a2.setFirstName("tamil");
    a2.setId(2);
    a2.setLastName("tamil");
 
    session.save(a2);
 
    System.out.println("successfully 3");
        session.save(e1);
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }
}
