package com.example.springboot3scheduledjobs.repositories;

import com.example.springboot3scheduledjobs.models.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepository extends ListCrudRepository<Product, Long> {
}

