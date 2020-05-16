package com.example.flightreservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.flightreservation.dto.ReservationRequest;
import com.example.flightreservation.entities.Flight;
import com.example.flightreservation.entities.Reservation;
import com.example.flightreservation.repos.FlightRepository;
import com.example.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId")Long flightId, ModelMap modelMap) {
		
		Optional<Flight> flight = flightRepository.findById(flightId);
		if(flight.isPresent()) {
			modelMap.addAttribute("flight", flight.get());
		}else {
			modelMap.addAttribute("msg", "No such flight available");
		}
		
		return "completeReservation";
	}
	
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		System.out.println(reservation.getId());
		modelMap.addAttribute("msg", "Reservation created successfully");
		return  "reservationConfirmation";
	}
}
