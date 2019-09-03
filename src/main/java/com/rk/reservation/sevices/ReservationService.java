package com.rk.reservation.sevices;

import com.rk.reservation.dto.ReservationRequest;
import com.rk.reservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
