package com.example.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmail(String email);
}
