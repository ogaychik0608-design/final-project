package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<Product> getProducts(String search, Long categoryId, Pageable pageable) {
        if (categoryId != null && categoryId > 0) {
            return productRepository.findAllByCategoryId(categoryId, pageable);
        }
        if (search != null && !search.isEmpty()) {
            return productRepository.findByNameContainingIgnoreCase(search, pageable);
        }
        return productRepository.findAll(pageable);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}