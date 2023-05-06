package com.Alekperova.CourseWork.repository;

import com.Alekperova.CourseWork.model.Cart;
import com.Alekperova.CourseWork.model.Product;
import com.Alekperova.CourseWork.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    void deleteById(Long id);
    List<User> findAllById(Long id);

}
