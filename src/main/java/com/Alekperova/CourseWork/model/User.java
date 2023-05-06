package com.Alekperova.CourseWork.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
//    @OneToMany(mappedBy =  "user", orphanRemoval=true, fetch = FetchType.EAGER)
//    private List<Cart> cart = new ArrayList<>();
}
