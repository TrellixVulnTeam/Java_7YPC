package com.example.springboot.entities;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String name;

    @ManyToMany(mappedBy="roles")
    private List<User> users;

    public Role() {
        users=new ArrayList<User>();
    }
}
