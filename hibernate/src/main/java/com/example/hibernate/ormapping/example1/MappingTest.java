package com.example.hibernate.ormapping.example1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingTest {
    public static void main(String[] args) {
        Member member=new Member();
        member.setName("maryam");

        Address address=new Address();
        address.setCity("Tehran");
        member.setAddress(address);

        SessionFactory sf=new Configuration().configure("projectConfig.xml").buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();
        session.save(member);
        session.save(address);
        tx.commit();
        session.close();
    }
}
