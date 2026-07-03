package com.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String args[])
    {

        Student s1=new Student();
        s1.setRoll(6);
        s1.setName("Mansi");
        s1.setAge(39);

        Student s2=null;

        Configuration cfg=new Configuration()
                .addAnnotatedClass(com.hib.Student.class)
                .configure();
        cfg.setProperty
                ("hibernate.connection.password",
                        System.getenv("DB_password"));

        SessionFactory fs=cfg.buildSessionFactory();
        Session session=fs.openSession();

        /*
        SAVING DATA IN DATABASE
        Transaction ts=session.beginTransaction();
        session.persist(s1);
        ts.commit();

         */



        s2=session.find(Student.class,5);

        session.close();
        fs.close();

        System.out.println(s2);
    }
}
