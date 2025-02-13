package com.example.Library_management.controller.users;

import com.example.Library_management.model.users.User;
import com.example.Library_management.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getUsers(){
        List<User> user = userService.getALLUsers();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<User>> getUsersById(@PathVariable long id){
        Optional<User> user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<User> create(@RequestBody User userForm){
        User user = userService.createUser(userForm);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> edit(@RequestBody User userForm, @PathVariable long id){

        User user = userService.editUser(userForm, id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable long id){

        User user = userService.deleteUser(id);
        return ResponseEntity.ok(user);
    }


}
