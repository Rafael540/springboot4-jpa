package com.rafael.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
