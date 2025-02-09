package com.example.Library_management.controller;

import com.example.Library_management.model.User;
import com.example.Library_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> user = userService.getALLUsers();
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user")
    public ResponseEntity<User> create(@RequestBody User userForm){
        User user = userService.createUser(userForm);
        return ResponseEntity.ok(user);
    }



}
