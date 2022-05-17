package com.example.springboot.documentmanagement.service;


import com.example.springboot.documentmanagement.dao.UserRepository;
import com.example.springboot.documentmanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
//@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity registerUser(User newUser){
        try{
            User user = userRepository.findByEmail(newUser.getEmail());
            if (user != null){
                System.out.println("User already exists with this email:" + user.getEmail());
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
            }
            else {
                newUser.setId(0);
                String encodedPassword = passwordEncoder.encode(newUser.getPassword());
                newUser.setPassword(encodedPassword);

                User savedUser = userRepository.save(newUser);
                System.out.println("User Registered with Id: " + savedUser.getId());
                return ResponseEntity.status(HttpStatus.OK).body(savedUser);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong, try again.");

    }


    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request){

        //decrypt password
//        String decryptedpasswd = aesAlgo.decrypt(password);
//
//        System.out.println("decryptedpass: " + decryptedpasswd);



        User user = userRepository.findByEmail(email);

        System.out.println("user:" + user);

        if (user != null){

            boolean res = passwordEncoder.matches(password, user.getPassword());

            if(res){

                request.getSession().setAttribute("user", user);

                return "user logged in successfully" + user.getId();
            }

            return "incorrect password, kindly try again!";
        }
        else {
            return "error logging in!";
        }
    }

    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public String logoutUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "user logged out!";
    }












//    @Transactional
//    public void save(User user) {
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//        userRepository.save(user);
//    }
//
//    @Transactional
//    public List<User> findAll() {
//        List<User> usersList = userRepository.findAll();
//        return usersList;
//    }
//
//    @Transactional
//    public User findUserByEmail(String email) {
//        User users = userRepository.findByEmail(email);
//        return users;
//    }
//
//    @Transactional
//    public User findByEmailAndPassword(String email, String password) {
//
//        passwordEncoder.matches(password, )
//        User user = userRepository.findByEmailAndPassword(email, password);
//        return user;
//    }


}
