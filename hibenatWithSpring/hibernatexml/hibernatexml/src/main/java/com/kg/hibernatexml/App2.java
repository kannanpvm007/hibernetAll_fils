package com.kg.hibernatexml;

// import javax.transaction.Transaction;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


// import org.hibernate.Session;
// import org.hibernate.SessionFactory;
// import org.hibernate.Transaction;
// import org.hibernate.boot.Metadata;
// import org.hibernate.boot.MetadataSources;
// import org.hibernate.boot.registry.StandardServiceRegistry;
// import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App2 {

    public static void main(String[] args) {
      
        StandardServiceRegistry SSR1 = new StandardServiceRegistryBuilder().configure("hi.cfg.xml").build(); 
        // StandardServiceRegistry SSR1= new StandardServiceRegistryBuilder().configure("hi.cfg.xml").build();
        Metadata meta1= new MetadataSources(SSR1).getMetadataBuilder().build();
        
        SessionFactory factory = meta1.getSessionFactoryBuilder().build();
        Session sc= factory.openSession();
        Transaction tc = sc.beginTransaction();

        Employee1 emp= new Employee1();
        emp.setId(1);
        emp.setUser("root");
    emp.setPassword("root");
    sc.save(emp)    ;
    tc.commit();
    System.out.println("done");
    factory.close();
    sc.close();

}
}