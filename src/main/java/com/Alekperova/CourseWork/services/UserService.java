package com.Alekperova.CourseWork.services;


import com.Alekperova.CourseWork.model.Cart;
import com.Alekperova.CourseWork.model.User;
import com.Alekperova.CourseWork.repository.CartRepository;
import com.Alekperova.CourseWork.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final CartRepository  cartRepository;

    private final UserRepository userRepository;

    public List<Cart> getAllCartsByUserId(Long id){
        List<Cart> carts = cartRepository.findAllByUserId(id);
        return carts;
    }

    public List<User> getAllUsers(){return userRepository.findAll();}
    public void saveOrUpdate(User user){userRepository.save(user);}
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
    public List<User> getUserById(Long id){return userRepository.findAllById(id);}

}
