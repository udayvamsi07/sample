package com.hb;
import org.hibernate.cfg.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hb.model.Student;
public class App 
{
    public static void main( String[] args )
    {
    
        Student obj=new Student();
        obj.setSid(5);
        obj.setName("jack");
        obj.setMarks(55);
        Configuration cfg=new Configuration();
        cfg.addAnnotatedClass(com.hb.model.Student.class);
        cfg.configure();
      SessionFactory sf=cfg.buildSessionFactory();
        Session s=sf.openSession();
        // Transaction t=s.beginTransaction();
        Transaction t=s.beginTransaction();

        s.persist(obj);
        t.commit();

        System.out.println(obj);

        
    }
}
