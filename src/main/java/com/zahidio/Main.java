package com.zahidio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Alien ao = new Alien();
        ao.setFirstName("Khaka");
        ao.setLastName("khan");
        ao.setPassword("zahidio");

        Laptop laptop = new Laptop();
        laptop.setModel("appple");
        laptop.setBrand("m1");
        laptop.setMemory("8 GB");

        ao.setLaptop(laptop);

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(com.zahidio.Alien.class);
        configuration.addAnnotatedClass(com.zahidio.Laptop.class);
        configuration.configure(); //here we can pass the config file name too if its not named hibernate.cfg.xml
        SessionFactory sf = configuration.buildSessionFactory();

        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();
        
        session.persist(ao);

//        Alien po = session.find(com.zahidio.Alien.class, 5);

//        System.out.println(po);

        trx.commit();
        session.close();

    }
}
