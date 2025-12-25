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

        Alien ao2 = new Alien();
        ao2.setFirstName("Ali");
        ao2.setLastName("Hadi");
        ao2.setPassword("test1234");

        Alien ao3 = new Alien();
        ao3.setFirstName("Zain");
        ao3.setLastName("Pala");
        ao3.setPassword("test1234");

        Laptop laptop = new Laptop();
        laptop.setModel("rog");
        laptop.setBrand("asus");
        laptop.setMemory("24 GB");

        Laptop laptop2 = new Laptop();
        laptop2.setModel("pavilion");
        laptop2.setBrand("hp");
        laptop2.setMemory("8 GB");

        Laptop laptop3 = new Laptop();
        laptop3.setModel("macbook");
        laptop3.setBrand("apple");
        laptop3.setMemory("16 GB");

        laptop.setAlien(Arrays.asList(ao, ao3));
        laptop2.setAlien(Arrays.asList(ao2));
        laptop3.setAlien(Arrays.asList(ao3, ao));

        ao.setLaptop(Arrays.asList(laptop, laptop3));
        ao2.setLaptop(Arrays.asList(laptop2));
        ao3.setLaptop(Arrays.asList(laptop3, laptop));


        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(com.zahidio.Alien.class);
        configuration.addAnnotatedClass(com.zahidio.Laptop.class);
        configuration.configure(); //here we can pass the config file name too if its not named hibernate.cfg.xml
        SessionFactory sf = configuration.buildSessionFactory();

        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();

        session.persist(ao);
        session.persist(ao2);
        session.persist(ao3);

//        Alien po = session.find(com.zahidio.Alien.class, 5);

//        System.out.println(po);

        trx.commit();
        session.close();

    }
}
