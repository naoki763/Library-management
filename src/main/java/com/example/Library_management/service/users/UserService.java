package com.example.Library_management.service.users;

import com.example.Library_management.exception.ResourceNotFoundException;
import com.example.Library_management.model.users.User;

import com.example.Library_management.repository.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getALLUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(long id){
        return userRepository.findById(id);
    }

    public Optional<User> getUserByName(String name){
        return userRepository.findByUsername(name);
    }

    public User createUser(User userForm){
        System.out.println(userForm.getUsername());
        System.out.println(userForm.getAddress());
        userRepository.save(userForm);
        return userForm;
    }

    public User editUser(User userForm, Long id ){
        User user = userRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found" + id));
        user.setUsername(userForm.getUsername());
        user.setAddress(userForm.getAddress());
        userRepository.save(user);
        return user;
    }
    public User deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found" + id));
        userRepository.delete(user);
        return user;
    }
}
