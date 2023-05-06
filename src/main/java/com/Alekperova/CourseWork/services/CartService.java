package com.Alekperova.CourseWork.services;


import com.Alekperova.CourseWork.exceptions.NotEnoughAmountException;
import com.Alekperova.CourseWork.exceptions.ObjectNotFonudException;
import com.Alekperova.CourseWork.model.Cart;
import com.Alekperova.CourseWork.model.Product;
import com.Alekperova.CourseWork.model.User;
import com.Alekperova.CourseWork.repository.CartRepository;
import com.Alekperova.CourseWork.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public void add(Cart cart) throws Exception{
        List<Product> productList = productRepository.findAllById(cart.getProductId());
        if(productList.size()==0){
            throw new ObjectNotFonudException("product: id" + cart.getProductId());
        }
        Product product = productList.get(0);
        Long amount = cart.getAmount();
        if(product.getAmount()<amount){
            throw new NotEnoughAmountException(product.getName() + ": " +product.getAmount());
        }
//        productRepository.delete(product);
        product.setAmount(product.getAmount()-cart.getAmount());
        productRepository.save(product);
        cartRepository.save(cart);
    }

    public void deleteByUserId(Long id){cartRepository.deleteByUserId(id);}

    public void delete(Cart cart){
        cartRepository.delete(cart);
    }

    public void deleteById(Long id){
        cartRepository.deleteById(id);
    }

    public List<Cart> getAllById(Long id){
        return cartRepository.findAllById(id);
    }

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    public List<Cart> getAllByUserId(Long id){
        return cartRepository.findAllByUserId(id);
    }

}
