package com.example.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightreservation.dto.ReservationRequest;
import com.example.flightreservation.entities.Flight;
import com.example.flightreservation.entities.Passenger;
import com.example.flightreservation.entities.Reservation;
import com.example.flightreservation.repos.FlightRepository;
import com.example.flightreservation.repos.PassengerRepository;
import com.example.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	public Reservation bookFlight(ReservationRequest request) {
		
		// TODO Auto-generated method stub
		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();
		System.out.println(" FlightID is ............." + flightId);
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		Passenger savedPassenger = passengerRepository.save(passenger);
		System.out.println(" PassengerName is ............." + request.getPassengerFirstName());
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		System.out.println(" PassengerID is ............." + savedPassenger.getId());
		reservation.setCheckedIn(false);
		Reservation savedReservation = reservationRepository.save(reservation);
		System.out.println(" PassengerReservation is ............." + savedReservation.getId());
		
		
		return savedReservation;
	}
	


}
