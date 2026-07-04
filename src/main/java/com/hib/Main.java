package com.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String args[])
    {

     Programmer pg=new Programmer();
     pg.setId(1);
     pg.setTech("Java");
     pg.setExp(10);

     Configuration cfg=new Configuration()
             .addAnnotatedClass(Programmer.class)
             .configure();

     cfg.setProperty("hibernate.connection.password"
             ,System.getenv("DB_password"));

     SessionFactory sf=cfg.buildSessionFactory();
     Session sess =sf.openSession();

     Transaction ts=sess.beginTransaction();
     sess.persist(pg);
     ts.commit();

     sess.close();
     sf.close();









//        Student s1=new Student();
//        s1.setRoll(2);
//        s1.setName("Ravi");
//        s1.setAge(50);
//
//        Student s2=new Student();
//        s2.setRoll(7);
//        s2.setName("Nick");
//        s2.setAge(30);
//
//
//
//        Student s3=null;
//
//        Configuration cfg=new Configuration()
//                .addAnnotatedClass(com.hib.Student.class)
//                .configure();
//        cfg.setProperty
//                ("hibernate.connection.password",
//                        System.getenv("DB_password"));
//
//        SessionFactory fs=cfg.buildSessionFactory();
//        Session session=fs.openSession();
//
//        /*
//        SAVING DATA IN DATABASE
//        Transaction ts=session.beginTransaction();
//        session.persist(s1);
//        ts.commit();
//         */
//
//
//        /*
//        FETCHING DATA
//        s2=session.find(Student.class,5);
//        */
//
//
//        /*
//
//        UPDATING DATA
//        Transaction ts= session.beginTransaction();
//        session.merge(s1);
//        session.merge(s2);
//        ts.commit();
//
//        */
//
//
//        //DELETING DATA
//        s3=session.find(Student.class,3);
//        Transaction ts=session.beginTransaction();
//        session.remove(s3);
//        ts.commit();
//
//
//        session.close();
//        fs.close();
//
//        System.out.println(s2);
    }
}
