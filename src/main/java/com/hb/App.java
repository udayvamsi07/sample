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
       // Student obj1=null;
        obj.setSid(7);
        obj.setName("eve");
        obj.setMarks(100);
    //    Configuration cfg=new Configuration();
    //     cfg.addAnnotatedClass(com.hb.model.Student.class);
    //    cfg.configure();
    //   SessionFactory sf=cfg.buildSessionFactory();
// or you can write like this
SessionFactory sf=new Configuration()
.addAnnotatedClass(com.hb.model.Student.class)
.configure()
.buildSessionFactory();
      
        Session s=sf.openSession();
        // Transaction t=s.beginTransaction();
      //  Transaction t=s.beginTransaction();
      //s.persist(obj);
       // t.commit();
     //  obj1=s.get(Student.class, 7);
Transaction t=s.beginTransaction();
s.merge(obj);//to update any data into database
t.commit();

        
        s.close();
        sf.close();
       // System.out.println(obj1.getName());

        
    }
}
