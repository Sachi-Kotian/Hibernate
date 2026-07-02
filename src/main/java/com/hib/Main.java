package com.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String args[])
    {

        Student s1=new Student();
        s1.setRoll(1);
        s1.setName("John");
        s1.setAge(20);

        Configuration cfg=new Configuration();
        cfg.addAnnotatedClass(com.hib.Student.class);
        cfg.configure();

        cfg.setProperty
                ("hibernate.connection.password",
                        System.getenv("DB_password"));

        SessionFactory fs=cfg.buildSessionFactory();
        Session session=fs.openSession();

        Transaction ts=session.beginTransaction();
        session.persist(s1);
        ts.commit();

        System.out.println(s1);
    }
}
