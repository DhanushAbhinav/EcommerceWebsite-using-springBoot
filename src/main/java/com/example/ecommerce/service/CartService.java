package com.example.ecommerce.service;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }

    public Cart updateCart(Cart cart) {
        return cartRepository.save(cart);
    }
}