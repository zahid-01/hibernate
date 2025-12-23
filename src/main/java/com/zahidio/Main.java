package com.zahidio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("hadi");
        student.setAge(20);
        student.setRollNumber(105);

        Student s2 = null;

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(com.zahidio.Student.class);
        configuration.configure();
        SessionFactory sf = configuration.buildSessionFactory();

        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();

//        session.persist(student);
        s2 = session.find(Student.class, 105);

        System.out.println(s2);

        trx.commit();
        session.close();

    }
}
