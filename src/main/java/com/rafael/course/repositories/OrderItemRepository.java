package com.rafael.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.course.entities.OrderItem;

import jakarta.persistence.Id;


public interface OrderItemRepository extends JpaRepository<OrderItem, Id> {

}
