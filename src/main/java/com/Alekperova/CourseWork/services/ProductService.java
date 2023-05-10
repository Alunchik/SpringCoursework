package com.Alekperova.CourseWork.services;


import com.Alekperova.CourseWork.model.Category;
import com.Alekperova.CourseWork.model.Product;
import com.Alekperova.CourseWork.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getById(Long id){return productRepository.findAllById(id);}
    public List<Product> getByName(String name){
        return productRepository.findAllByNameContaining(name);
    }
    public List<Product> getByCategory(Category category){
        return productRepository.findAllByCategory(category);
    }
    public List<Product> getByPrice(Long price1, Long price2){
        return productRepository.findAllByPriceBetween(price1, price2);
    }
    public void add(Product product){
        productRepository.save(product);
    }
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}
