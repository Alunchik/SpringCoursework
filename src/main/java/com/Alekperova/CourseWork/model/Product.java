package com.Alekperova.CourseWork.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="price")
    private Long price;
    @Column(name="amount")
    private Long amount;
    @Column(name="name")
    private String name;
//    @Column(name="category")
//    private Category category;
}