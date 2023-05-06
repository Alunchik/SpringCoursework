package com.Alekperova.CourseWork.controllers;

import com.Alekperova.CourseWork.model.Cart;
import com.Alekperova.CourseWork.model.Product;
import com.Alekperova.CourseWork.services.CartService;
import com.Alekperova.CourseWork.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/carts")
    public Cart addProduct(@RequestBody Cart cart){
        try {
            cartService.add(cart);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return cart;
    }

    @GetMapping("/carts")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }




    @DeleteMapping("carts")
    public List<Cart> deleteCartById(Long id){
        List<Cart> li = cartService.getAllById(id);
        cartService.deleteById(id);
        return li;
    }

    @DeleteMapping("carts/{id}")
    public List<Cart> deleteCartsByUserId(@PathVariable("id") Long id){
        List<Cart> li = cartService.getAllByUserId(id);
        cartService.deleteByUserId(id);
        return li;
    }
}
