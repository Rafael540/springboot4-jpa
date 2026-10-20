package com.rafael.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {


		
}
