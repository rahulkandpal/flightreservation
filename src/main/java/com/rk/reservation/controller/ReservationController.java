package com.rk.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rk.reservation.dto.ReservationRequest;
import com.rk.reservation.entities.Flight;
import com.rk.reservation.entities.Reservation;
import com.rk.reservation.repository.FlightRepository;
import com.rk.reservation.sevices.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap modelMap)
	{
		Flight flight= flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		return "login/completeReservation";
	}
	
	@PostMapping("/completeReservation")
	//@RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request,ModelMap modelMap)
	{
		Reservation reservation =reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "reservation created successfully and the reservation id is "+reservation.getId());
		return "login/reservationConfirmation";
	}
}
