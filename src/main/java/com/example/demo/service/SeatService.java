package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.AirFlight;
import com.example.demo.model.AirFlightseat;
import com.example.demo.model.temppassengerticketbook;

@Service
public interface SeatService {
	List<AirFlightseat> getbookedseats(AirFlight af);
	
}
