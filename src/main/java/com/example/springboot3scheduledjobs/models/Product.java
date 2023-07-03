package com.example.springboot3scheduledjobs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    Long id;

    String name;

    String description;

    Integer quantity;

    Double price;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

}