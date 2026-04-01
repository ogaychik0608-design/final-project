package com.example.demo.rest_controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService productService;

    @GetMapping
    public Page<Product> list(
            @RequestParam(required = false) String search,
            @PageableDefault(size = 6) Pageable pageable) {
        return productService.getProducts(search, pageable);
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @PatchMapping("/{id}/stock")
    public Product changeStock(@PathVariable Long id, @RequestParam int amount) {
        return productService.updateStock(id, amount);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}