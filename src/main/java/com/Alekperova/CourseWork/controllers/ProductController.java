package com.Alekperova.CourseWork.controllers;


import com.Alekperova.CourseWork.model.Category;
import com.Alekperova.CourseWork.model.Product;
import com.Alekperova.CourseWork.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        productService.add(product);
        return product;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/category/{category}")
    public List<Product> getAllProductsByCategory(@PathVariable("category") Category category) {

        return productService.getByCategory(category);
    }
    @GetMapping("/products/name_search")
    public List<Product> getProductsByName(@RequestParam("name") String name){
        return productService.getByName(name);
    }

    @GetMapping("/products/price_filter")
    public List<Product> getProductBetweenPrice(@RequestParam("low") Long low, @RequestParam("high") Long high){
        return productService.getByPrice(low, high);
    }

//    @GetMapping("/products/{category}")
//    public List<Product> getProductInCategory(@PathVariable Category category){
//        return productService.getByCategory(category);
//    }

    @GetMapping("/products/{id}")
    public List<Product> getProductById(@PathVariable("id") Long id){
        List<Product> product = productService.getById(id);
        return product;
    }


    @DeleteMapping("/products")
    public List<Product> deleteProductById(@RequestParam Long id){
        List<Product> product = productService.getById(id);
        productService.deleteById(id);
        return product;
    }
}
