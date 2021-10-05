package com.example.demo;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer3.BookingRepository.BookingRepositoryImpl;
import com.example.demo.layer3.CancellationRepository.CancellationRepositoryImpl;
import com.example.demo.layer3.FlightRepository.FlightRepositoryImpl;
import com.example.demo.layer3.PassengerTicketBookRepository.PassengerTicketBookRepositoryImpl;
import com.example.demo.layer3.TransactionReository.TransactionRepositoryImpl;
import com.example.demo.model.AirBooking;
import com.example.demo.model.AirCancellation;
import com.example.demo.model.AirFlight;
import com.example.demo.model.AirPassengerticketbook;
import com.example.demo.model.AirTransaction;
import com.example.demo.service.NewBookingServiceImpl;

@CrossOrigin("*")
@RestController
public class BaseController {
	@Autowired
	TransactionRepositoryImpl tr;
	
	@Autowired
	FlightRepositoryImpl flightrepo;
	
	@Autowired
	CancellationRepositoryImpl cancelrepo;
	
	@Autowired
	BookingRepositoryImpl bookrepo;
	
	@Autowired
	PassengerTicketBookRepositoryImpl  passticbook;
	
	
/*	@Autowired
	BookingServiceImpl bs;
	
	@RequestMapping(path="/getuserbooking")
	public List<AirBooking> getuserbooking() {
		System.out.println("greeting3");
		return bs.getallbookings(101);
	}*/
	
	@RequestMapping(path="/gettransactions")
	public List<AirTransaction> gettransaction() {
		System.out.println("greeting3");
		return tr.selectAllTransacion();
	}
	
	@RequestMapping(path="/getflights")
	public List<AirFlight> getflights() {
		System.out.println("greeting3");
		return flightrepo.findAllFlights("AirFlight");
	}
	
	@RequestMapping(path="/getcancelling")
	public List<AirCancellation> getcancel() {
		System.out.println("greeting3");
		return cancelrepo.selectAllCancellation();
	}
	
	
	
	
	
	
	
	
}
