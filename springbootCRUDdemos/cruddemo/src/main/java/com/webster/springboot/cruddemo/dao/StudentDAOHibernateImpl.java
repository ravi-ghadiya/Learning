package com.webster.springboot.cruddemo.dao;

import com.webster.springboot.cruddemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOHibernateImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        //unwrap entitymanager and get current hibernate session
        Session session = entityManager.unwrap(Session.class);

        Query<Student> query = session.createQuery("from Student", Student.class);

        List<Student> students = query.getResultList();

        return students;
    }

    @Override
    public Student findById(int id) {
        Session session = entityManager.unwrap(Session.class);

        Student student = session.get(Student.class, id);

        return student;
    }

    @Override
    public void save(Student student) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(student);

    }

    @Override
    public void deletebyId(int id) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("delete from Student where id=:studentId");

        query.setParameter("studentId", id);

        int result = query.executeUpdate();
    }
}
