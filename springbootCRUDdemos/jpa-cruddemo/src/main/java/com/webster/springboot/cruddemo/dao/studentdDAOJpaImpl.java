package com.webster.springboot.cruddemo.dao;

import com.webster.springboot.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class studentdDAOJpaImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public studentdDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        Query query = entityManager.createQuery("from Student");
        List<Student> studentsList = query.getResultList();
        return studentsList;
    }

    @Override
    public Student findById(int id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    @Override
    public void save(Student student) {
        Student st = entityManager.merge(student);
        student.setId(st.getId());

    }

    @Override
    public void deletebyId(int id) {
        Query query = entityManager.createQuery("delete from Student where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();

        // entityManager.remove(id);

    }
}
