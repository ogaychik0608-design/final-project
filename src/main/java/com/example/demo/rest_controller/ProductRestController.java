package com.example.demo.rest_controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.FileService;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final FileService fileService;

    @GetMapping
    public Page<Product> getAll(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Long categoryId,
            Pageable pageable) {
        return productService.getProducts(search, categoryId, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Product product = productService.getById(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Product> saveOrUpdate(
            @ModelAttribute Product product,
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "categoryId", required = false) Long categoryId,
            @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {

        if (id != null) {
            product.setId(id);
            Product existing = productService.getById(id);
            if (existing != null && (image == null || image.isEmpty())) {
                product.setImageName(existing.getImageName());
            }
        }

        if (categoryId != null) {
            Category category = categoryService.getById(categoryId);
            if (category != null) {
                if (product.getCategories() == null) product.setCategories(new HashSet<>());
                product.getCategories().clear();
                product.getCategories().add(category);
            }
        }

        if (image != null && !image.isEmpty()) {
            product.setImageName(fileService.saveFile(image));
        }

        return ResponseEntity.ok(productService.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }


}