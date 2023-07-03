package com.example.springboot3scheduledjobs.services;

import com.example.springboot3scheduledjobs.models.Product;
import com.example.springboot3scheduledjobs.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setCreatedAt(LocalDateTime.now());
        }

        product.setUpdatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }
}
