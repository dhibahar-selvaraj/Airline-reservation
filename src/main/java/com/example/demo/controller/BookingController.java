package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AirBooking;
import com.example.demo.model.AirFlight;
import com.example.demo.model.AirPassengerticketbook;
import com.example.demo.service.NewBookingServiceImpl;

@CrossOrigin("*")
@RestController
public class BookingController {
	
	@Autowired
	NewBookingServiceImpl nbsi;
	
	@RequestMapping(path="/getuserbooking/{user}")
	public List<AirBooking> getuserbooking(@PathVariable int user) {
		System.out.println("greeting3");
		return nbsi.getallUserbookings(user);
	}
	
	@RequestMapping(path="/getallbooking")
	public List<AirBooking> getallbooking() {
		System.out.println("greeting3");
		return nbsi.selectAllBooking();
	}
	
	@PostMapping
	@RequestMapping(path="/addbooking2")  
	public AirBooking addbook(@RequestBody AirBooking book)
	{
		return nbsi.addBooking((AirBooking)book);
	}
	
	@PostMapping
	@RequestMapping(path="/cancelflight")  
	public void addbook(@RequestBody AirFlight af)
	{
		List<AirBooking> ab=af.getAirBookings();
		for(AirBooking book: ab) {
			nbsi.cancelBooking(book);
		}
	}
	
	@PostMapping
	@RequestMapping(path="/addcancelling")  
	public void addCancel(@RequestBody AirBooking book)
	{
		System.out.println("cancelling is called ");
		nbsi.cancelBooking(book);
	}
	
	@RequestMapping(path="/getpassticket")
	public List<AirPassengerticketbook> getpassticket() {
		System.out.println("greeting3");
		return nbsi.getpassticket(132);
	}
	
	@PostMapping
	@RequestMapping(path="/addpassticket")  
	public void addpassticket(@RequestBody AirPassengerticketbook psbook)
	{
		nbsi.setpassticket(psbook);
	}
}
