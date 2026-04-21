package com.example.demo.rest_controller;

import com.example.demo.dto.CartItemDTO;
import com.example.demo.model.User;
import com.example.demo.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartRestController {
    private final CartService cartService;

    @PostMapping("/add/{productId}")
    public void addToCart(@PathVariable(value = "productId") Long productId,
                          @RequestBody User user) {
        cartService.addToCart(user, productId);
    }

    @PostMapping("/get")
    public List<CartItemDTO> getCart(@RequestBody User user) {
        return cartService.getCartDTO(user);
    }

    @DeleteMapping("/remove/{cartItemId}")
    public void removeFromCart(@PathVariable Long cartItemId) {
        cartService.removeFromCart(cartItemId);
    }
}