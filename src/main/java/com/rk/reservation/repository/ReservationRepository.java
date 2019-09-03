package com.rk.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.reservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
