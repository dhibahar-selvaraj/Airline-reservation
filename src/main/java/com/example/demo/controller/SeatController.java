package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer3.FlightRepository.FlightRepositoryImpl;
import com.example.demo.model.AirBooking;
import com.example.demo.model.AirFlight;
import com.example.demo.model.AirFlightseat;
import com.example.demo.model.temppassengerticketbook;
import com.example.demo.service.SeatServiceImpl;

@CrossOrigin("*")
@RestController
public class SeatController {
	@Autowired
	SeatServiceImpl seatserv;
	
	@Autowired
	FlightRepositoryImpl frepo;
	
	
	
	@RequestMapping(path="/getallbookedseats/{fno}")
	public List<AirFlightseat> getallbookingseats(@PathVariable int fno) {
		AirFlight af=frepo.findFlight(fno);
		System.out.println("greeting3");
		return seatserv.getbookedseats(af);
	}
}