package com.rk.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.reservation.dto.ReservationUpdateRequest;
import com.rk.reservation.entities.Reservation;
import com.rk.reservation.repository.ReservationRepository;

@RestController
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation( @PathVariable("id") Long id)
	{
		return  reservationRepository.findById(id).get();
	}
	
	@RequestMapping("reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request)
	{
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.isCheckedIn());
		
		Reservation updateReservation = reservationRepository.save(reservation);
		
		return updateReservation;
		
	}
}
