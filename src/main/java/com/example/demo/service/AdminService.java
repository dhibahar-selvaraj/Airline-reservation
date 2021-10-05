package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.model.AirAdmin;
import com.example.demo.model.AirBooking;
import com.example.demo.model.AirFlight;
import com.example.demo.model.AirUser;

@Service
public interface AdminService {
	void deleteflight(AirFlight af);
	List<AirFlight> getallflights();
	List<AirFlight> getallcancelledflights();
	void insertflight(AirFlight af);
	void admincancelBooking(AirBooking book);
	AirAdmin login(String id, String password);
}
