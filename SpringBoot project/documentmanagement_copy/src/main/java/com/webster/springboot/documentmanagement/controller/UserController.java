package com.webster.springboot.documentmanagement.controller;

import com.webster.springboot.documentmanagement.entity.User;
import com.webster.springboot.documentmanagement.model.LoginRequest;
import com.webster.springboot.documentmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User newUser) {
        ResponseEntity result = userService.registerUser(newUser);
        return result;
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest request) {
        String result = userService.loginUser(request);
        return result;
    }

    @PostMapping("/logout")
    public String logoutUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String sessionId) {
        String result = userService.logoutUser(sessionId);
        return result;
    }

    //TODO LOGOUT ALL Session

}
