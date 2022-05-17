package com.example.springboot.documentmanagement.dao;

import com.example.springboot.documentmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findById(int id);

    @Query("from User where email=?1")
    public User findByEmail(String email);

    @Query("from User where email=?1 and password=?2")
    public User findByEmailAndPassword(String email,String password);
}
