package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.AirBooking;
import com.example.demo.model.AirPassengerticketbook;

@Service
public interface NewBookingService {
	List<AirBooking> getallUserbookings(int uno);
	List<AirBooking> selectAllBooking();
	AirBooking addBooking(AirBooking book);
	void cancelBooking(AirBooking cancel);
	List<AirPassengerticketbook> getpassticket(int bid);
	void setpassticket(AirPassengerticketbook apt);
}
