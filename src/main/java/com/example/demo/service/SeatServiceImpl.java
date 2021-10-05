package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer3.FlightRepository.FlightRepositoryImpl;
import com.example.demo.layer3.FlightseatRepository.FlightseatRepositoryImpl;
import com.example.demo.layer3.PassengerTicketBookRepository.PassengerTicketBookRepositoryImpl;
import com.example.demo.model.AirBooking;
import com.example.demo.model.AirFlight;
import com.example.demo.model.AirFlightseat;
import com.example.demo.model.AirPassengerticketbook;
import com.example.demo.model.AirPassengerticketbookPK;
import com.example.demo.model.temppassengerticketbook;

@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	FlightRepositoryImpl flightrepo;
	
	@Autowired
	FlightseatRepositoryImpl seatrepo;
	

	
	@Override
	public List<AirFlightseat> getbookedseats(AirFlight af) {
		List<AirFlightseat> seats =  new ArrayList<AirFlightseat>();
		List<AirBooking> ab=af.getAirBookings();
		for(AirBooking book: ab) {
			List<AirPassengerticketbook> curr=book.getAirPassengerticketbooks();
			for(AirPassengerticketbook apt: curr) {
				if(seatrepo.selectFlightseatbyid(apt.getSeatNumber())!=null) {
					seats.add(seatrepo.selectFlightseatbyid(apt.getSeatNumber()));
				}
			}
		}
		return seats;
	}


}
