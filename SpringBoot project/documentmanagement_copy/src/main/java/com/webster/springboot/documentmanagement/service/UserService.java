package com.webster.springboot.documentmanagement.service;

import com.webster.springboot.documentmanagement.entity.User;
import com.webster.springboot.documentmanagement.model.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity registerUser(User newUser);

    public String loginUser(LoginRequest request);

    public String logoutUser(String sessionId);
}
