package com.example.springboot.documentmanagement.controller;


import com.example.springboot.documentmanagement.model.User;
import com.example.springboot.documentmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User newUser){
        ResponseEntity result = userService.registerUser(newUser);
        return result;
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request){
        String result = userService.loginUser(email, password, request);
        return result;
    }

    @PostMapping("/logout")
    public String logoutUser(HttpServletRequest request){
        String result = userService.logoutUser(request);
        return result;
    }


}
