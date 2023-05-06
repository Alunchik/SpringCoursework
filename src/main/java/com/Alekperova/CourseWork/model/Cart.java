package com.Alekperova.CourseWork.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cart")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long amount;
    @Column(name="productId")
    private Long productId;
//    @Getter
//    @Setter
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
    @Column(name="user_id")
    private Long userId;
//    private User user;
//    @Column(name="category")
//    private Category category;
}
