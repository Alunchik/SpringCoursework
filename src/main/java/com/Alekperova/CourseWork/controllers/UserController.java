package com.Alekperova.CourseWork.controllers;

import com.Alekperova.CourseWork.model.Cart;
import com.Alekperova.CourseWork.model.Product;
import com.Alekperova.CourseWork.model.User;
import com.Alekperova.CourseWork.services.ProductService;
import com.Alekperova.CourseWork.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        userService.saveOrUpdate(user);
        return user;
    }

    @DeleteMapping("/users")
    public List<User> deleteUser(@RequestParam Long id){
        List<User> user = userService.getUserById(id);
        userService.deleteById(id);
        return user;
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/users/{id}")
    public List<User> getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/carts/{id}")
    public List<Cart> getAllCartsByUserId(@PathVariable("id") Long id) {
        return userService.getAllCartsByUserId(id);
    }
}
