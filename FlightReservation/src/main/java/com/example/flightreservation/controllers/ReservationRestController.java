package com.example.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightreservation.dto.ReservationUpdateRequest;
import com.example.flightreservation.entities.Reservation;
import com.example.flightreservation.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {
	
	@Autowired
	ReservationRepository reservationRepository; 
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		return reservationRepository.findById(id).get();
	}

	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.isCheckedIn());
		Reservation updatedReservation = reservationRepository.save(reservation); 
		return updatedReservation;
		
	}
}
