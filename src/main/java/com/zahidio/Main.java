package com.zahidio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Alien ao = new Alien();
        ao.setFirstName("Mohammad");
        ao.setLastName("Hadi");
        ao.setPassword("test1234");

        Laptop laptop = new Laptop();
        laptop.setModel("rog");
        laptop.setBrand("asus");
        laptop.setMemory("24 GB");

        Laptop laptop2 = new Laptop();
        laptop2.setModel("pavilion");
        laptop2.setBrand("hp");
        laptop2.setMemory("8 GB");

//        ao.setLaptop(Arrays.asList(laptop, laptop2));
        laptop.setAlien(ao);
        laptop2.setAlien(ao);

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
