package com.example.livraria.repositories;

import com.example.livraria.domain.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByCod(String cod);

}