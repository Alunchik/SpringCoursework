package com.Alekperova.CourseWork.repository;

import com.Alekperova.CourseWork.model.Cart;
import com.Alekperova.CourseWork.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUserId(Long userId);

    void deleteById(Long id);
    void deleteByUserId(Long id);

    List<Cart> findAllById(Long id);

}
