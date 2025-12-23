package com.zahidio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Zahid");
        student.setAge(20);
        student.setRollNumber(101);

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(com.zahidio.Student.class);
        configuration.configure();
        SessionFactory sf = configuration.buildSessionFactory();

        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();

        session.persist(student);

        trx.commit();

    }
}
