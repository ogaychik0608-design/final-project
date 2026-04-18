package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.categories " +
            "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))",
            countQuery = "SELECT COUNT(DISTINCT p) FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<Product> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT DISTINCT p FROM Product p JOIN p.categories c LEFT JOIN FETCH p.categories " +
            "WHERE c.id = :categoryId",
            countQuery = "SELECT COUNT(DISTINCT p) FROM Product p JOIN p.categories c WHERE c.id = :categoryId")
    Page<Product> findAllByCategoryId(@Param("categoryId") Long categoryId, Pageable pageable);

    @Query(value = "SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.categories",
            countQuery = "SELECT COUNT(DISTINCT p) FROM Product p")
    Page<Product> findAll(Pageable pageable);
}