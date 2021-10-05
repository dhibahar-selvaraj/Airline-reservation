package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AirFlight;
import com.example.demo.model.AirFlightseat;
import com.example.demo.model.AirPassenger;
import com.example.demo.model.temppassengerticketbook;
import com.example.demo.service.PassengerServiceImpl;

@CrossOrigin("*")
@RestController
public class PassengerController {
	
	@Autowired
	PassengerServiceImpl pskserv;
	
	@PostMapping
	@RequestMapping(path="/addpasstickettemp")  
	public temppassengerticketbook addPAsstickettemp(@RequestBody temppassengerticketbook temppsk)
	{
		System.out.println("addpassticket is called ");
		System.out.println(temppsk.getPassengerId());
		System.out.println(temppsk.getSeatNumber());
		System.out.println(temppsk.getTicketId());
		pskserv.setpassticketbook(temppsk);
		return temppsk;
	}
	
	
	@PostMapping
	@RequestMapping(path="/addpassenger")  
	public long addPassenger(@RequestBody AirPassenger ap)
	{
		pskserv.addpassenger((AirPassenger)ap);
		return ap.getPassengerId();
	}
	
	
	@RequestMapping(path="/getpassengers")
	public List<AirPassenger> getallPassengers() {
		
		return pskserv.getpassengers();
	}
}
