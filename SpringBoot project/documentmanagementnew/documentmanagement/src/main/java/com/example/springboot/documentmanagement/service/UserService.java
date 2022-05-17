package com.example.springboot.documentmanagement.service;


import com.example.springboot.documentmanagement.model.User;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    public ResponseEntity registerUser(User newUser);

    public String loginUser(String email, String password, HttpServletRequest request);

    public String logoutUser(HttpServletRequest request);
}
