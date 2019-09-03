package com.rk.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.reservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
