package com.rafael.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.course.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
