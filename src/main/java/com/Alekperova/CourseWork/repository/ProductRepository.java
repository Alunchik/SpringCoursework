package com.Alekperova.CourseWork.repository;

import com.Alekperova.CourseWork.model.Category;
import com.Alekperova.CourseWork.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(Category category);
    List<Product> findAllByNameContaining(String name);
    List<Product> findAllByPriceBetween(Long price1, Long price2);
    void deleteById(Long id);

    List<Product> findAllById(Long id);
    //List<Product> findAllByPriceLessThen(Long price);
    //List<Product> findAllByPriceGreaterThen(Long price);
   // List<Product> findAllByAmountGreaterThen(Long amount);
}
