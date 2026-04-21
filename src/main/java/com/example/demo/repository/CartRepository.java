package com.example.demo.repository;

import com.example.demo.model.CartItem;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAllByUser(User user);
    Optional<CartItem> findByUserAndProductId(User user, Long productId);
}