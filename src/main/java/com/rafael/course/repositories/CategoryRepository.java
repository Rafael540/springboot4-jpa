package com.rafael.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.course.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
