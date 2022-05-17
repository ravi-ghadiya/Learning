package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryDemo {


    private static List<Student> studentsList;

    public static void main(String[] args) {

        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();

        try {
            //display all students in table
//       studentsList = session.createQuery("from Student").getResultList();

            //display students with city= Mumbai
//        studentsList = session.createQuery("from Student where city='Mumbai'").list();

            //display students with city=Mumbai OR name=Amit
//        studentsList = session.createQuery("from Student where city='Mumbai' OR name='Amit'").list();


            //// query students where city LIKE '%bad'
            studentsList = session.createQuery("from Student where city LIKE '%bad'").list();


            //display students
            showStudents(studentsList);

        }

        finally {
            session.close();
            factory.close();
        }


    }

    private static void showStudents(List<Student> studentsList) {
        for (Student student: studentsList) {
            System.out.println(student);
        }
    }

}
