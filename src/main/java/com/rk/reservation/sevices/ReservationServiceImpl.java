package com.rk.reservation.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.reservation.dto.ReservationRequest;
import com.rk.reservation.entities.Flight;
import com.rk.reservation.entities.Passenger;
import com.rk.reservation.entities.Reservation;
import com.rk.reservation.repository.FlightRepository;
import com.rk.reservation.repository.PassengerRepository;
import com.rk.reservation.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		//Make Payment
		
		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();
		
		 Passenger passenger = new Passenger();
		 passenger.setFirstName(request.getPassengerFirstName());
		 passenger.setLastName(request.getPassengerLastName());
		 passenger.setEmail(request.getPassengerEmail());
		 passenger.setPhone(request.getPassengerPhone()); 
		 
		 Passenger savedPassenger=passengerRepository.save(passenger);
		 
		 Reservation reservation = new Reservation();
		 reservation.setFlight(flight);
		 reservation.setPassenger(savedPassenger);
		 reservation.setCheckedIn(false);
		 
		 Reservation savedReservation=reservationRepository.save(reservation);
		 
		return savedReservation;
	}

}
