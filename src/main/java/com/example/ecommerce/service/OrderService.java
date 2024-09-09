package com.example.ecommerce.service;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order placeOrder(Long userId) {
        List<Cart> cartItems = cartRepository.findByUserId(userId);
        double totalPrice = 0.0;

        for (Cart item : cartItems) {
            Product product = item.getProduct();
            if (product.getStock() < item.getQuantity()) {
                throw new IllegalStateException("Not enough stock for product: " + product.getName());
            }
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);
            totalPrice += product.getPrice() * item.getQuantity();
        }

        Order order = new Order();
        order.setUser(cartItems.get(0).getUser());
        order.setTotalPrice(totalPrice);
        orderRepository.save(order);

        cartRepository.deleteAll(cartItems);
        return order;
    }
}