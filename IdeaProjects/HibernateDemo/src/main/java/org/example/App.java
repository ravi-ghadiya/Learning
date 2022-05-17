package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;


public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        System.out.println(factory);



        //open new session from session factory
        Session session =  factory.getCurrentSession();

        //1. begin Transaction,
        // 2. Perform Operation (ex: save object, retrieve from DB, query object, update, delete, etc.)
        // 3. commit transaction


        try {
            Course course = new Course(11, "Java");

            FileInputStream fis = new FileInputStream("src/main/java/resources/profile.jpg");
            byte[] data = new byte[fis.available()];
            fis.read(data);

            Student student = new Student("Tanmay", "Hyderabad", 5.5 , course, new Date(), data);


            // create
            Transaction tr = session.beginTransaction();
            session.save(student);
            tr.commit();

            // find out the student's id: primary key
            System.out.println("Saved student. Generated id: " + student.getSid());


            //read from DB
            session = factory.getCurrentSession();
            Transaction tr1 = session.beginTransaction();
            Student student1 = session.get(Student.class, student.getSid());
            System.out.println("result: "+ student1);
            tr1.commit();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close factory once all things are performed
            factory.close();
        }
    }
}
