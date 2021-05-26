package org.orakris;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // storing data
        Teacher t1 = new Teacher();
        t1.setName("tabc");

        Teacher t2 = new Teacher();
        t2.setName("tdef");

        Student s1 = new Student();
        s1.setName("sabc");
        ArrayList<Teacher> l1 = new ArrayList<>();
        l1.add(t1);
        l1.add(t2);
        s1.setTeacherList(l1);

        Teacher t3 = new Teacher();
        t3.setName("tghi");

        Teacher t4 = new Teacher();
        t4.setName("tjkl");

        Student s2 = new Student();
        s2.setName("sdef");
        ArrayList<Teacher> l2 = new ArrayList<>();
        l2.add(t3);
        l2.add(t4);
        s2.setTeacherList(l2);

        session.persist(s1);
        session.persist(s2);

        transaction.commit();
        session.close();
        System.out.println("success");
    }
}
