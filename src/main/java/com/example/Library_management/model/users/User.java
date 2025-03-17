package com.example.Library_management.model.users;


import com.example.Library_management.model.history.History;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private  String address;

    @OneToMany(mappedBy = "user")
    private List<History> history;

}
