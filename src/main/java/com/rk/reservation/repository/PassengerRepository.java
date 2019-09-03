package com.rk.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.reservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
