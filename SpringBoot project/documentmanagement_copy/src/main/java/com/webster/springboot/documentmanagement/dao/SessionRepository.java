package com.webster.springboot.documentmanagement.dao;

import com.webster.springboot.documentmanagement.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<UserSession, Long> {

    //POWER OF JPA
    UserSession findBySessionIdAndActive(String sessionId, boolean active);

    List<UserSession> findByUserIdAndActive(Long userId, boolean active);
}
