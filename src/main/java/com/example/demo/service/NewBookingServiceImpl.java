package com.example.demo.service;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer3.BookingRepository.BookingRepositoryImpl;
import com.example.demo.layer3.CancellationRepository.CancellationRepositoryImpl;
import com.example.demo.layer3.FlightRepository.FlightRepositoryImpl;
import com.example.demo.layer3.PassengerTicketBookRepository.PassengerTicketBookRepositoryImpl;
import com.example.demo.layer3.TransactionReository.TransactionRepositoryImpl;
import com.example.demo.layer3.UserRepository.UserRepositoryImpl;
import com.example.demo.model.AirBooking;
import com.example.demo.model.AirCancellation;
import com.example.demo.model.AirFlight;
import com.example.demo.model.AirPassengerticketbook;
import com.example.demo.model.AirTransaction;
import com.example.demo.model.AirUser;

@Service
public class NewBookingServiceImpl implements NewBookingService {
	
	@Autowired
	NewBookingServiceImpl nbsi;
	
	@Autowired
	TransactionRepositoryImpl tr;
	
	@Autowired
	FlightRepositoryImpl flightrepo;
	
	@Autowired
	BookingRepositoryImpl bookrepo;
	
	@Autowired
	UserRepositoryImpl userrepo;
	
	@Autowired
	PassengerTicketBookRepositoryImpl  passticbook;
	
	@Autowired
	CancellationRepositoryImpl cancelrepo;

	
	public List<AirBooking> getallUserbookings(int uno) {
		System.out.println("welcome tp service");
		AirUser au=userrepo.SelectUserById(uno);
		List<AirBooking> abList= au.getAirBookings();
		List<AirBooking> result=new ArrayList<AirBooking>();
		for(AirBooking ab: abList) {
			 System.out.println("booking status " +ab.getBookingStatus());
			if(ab.getBookingStatus().equals("succeded")) {
				result.add(ab);
			}
		}
		return result;
		
	}

	@Override
	public List<AirBooking> selectAllBooking() {
		return bookrepo.selectAllBooking();
	}

	@Override
	public AirBooking addBooking(AirBooking book) {
		AirBooking newbook = (AirBooking) book;
		newbook.setBookingId(null);
		AirTransaction at=new AirTransaction();
		at.setTransactionAmount(book.getTotalCost());
		at.setTransactionType("c");
		at.setTransactionStatus("succeded");
		tr.insertTransaction(at);
		System.out.println("transaction is done");	
		
		AirFlight af=newbook.getAirFlight();
		
		af.setAvailableBussinessSeats(af.getAvailableBussinessSeats()-newbook.getBussinessSeatsBooked());
		af.setAvailableEconomySeats(af.getAvailableEconomySeats()-newbook.getEconomySeatsBooked());
		flightrepo.updateFlight(af);
		System.out.println("flight updated");
		newbook.setAirTransaction(at);
		Date d=new Date();
		newbook.setBookingDate(new Timestamp(d.getTime()));
		newbook.setBookingStatus("succeded");
		System.out.println("addflight :  "+newbook.getBookingStatus()+newbook.getBussinessSeatsBooked()); 
		bookrepo.insertBooking(newbook);
		return newbook;
	}

	@Override
	public void cancelBooking(AirBooking book) {
		AirBooking newbook = (AirBooking) book;
		newbook.setBookingStatus("cancelled");
		bookrepo.updateBooking(newbook);
		System.out.println("booking updated");
		AirTransaction at=new AirTransaction();
		at.setTransactionMode(newbook.getAirTransaction().getTransactionMode());
		at.setTransactionAmount(newbook.getTotalCost());
		at.setTransactionMode(book.getAirTransaction().getTransactionMode());
		at.setTransactionStatus("succeded");
		tr.insertTransaction(at);
		System.out.println("transaction updated");
		
		AirFlight af=newbook.getAirFlight();
		af.setAvailableBussinessSeats(af.getAvailableBussinessSeats()+newbook.getBussinessSeatsBooked());
		af.setAvailableEconomySeats(af.getAvailableEconomySeats()+newbook.getEconomySeatsBooked());
		flightrepo.updateFlight(af);
		System.out.println("flight updated");
		
		AirCancellation cancel=new AirCancellation();
		cancel.setAirTransaction(at);
		cancel.setCancellationId(newbook.getBookingId());
		cancel.setAirBooking(newbook);
		cancel.setRefundAmount(newbook.getTotalCost());
		Date d=new Date();
		cancel.setCancellationDate(new Timestamp(d.getTime()) );
		cancelrepo.insertCancellation(cancel);
		System.out.println("cancellation added");
		
		List<AirPassengerticketbook> aplist=newbook.getAirPassengerticketbooks();
		for(AirPassengerticketbook unit: aplist) {
				passticbook.deletePassengerTicketBook(unit.getId());
		}
		System.out.println("seat is deleted");
	}

	@Override
	public List<AirPassengerticketbook> getpassticket(int bid) {
		AirBooking at=bookrepo.selectBookingbyid(bid);
		return at.getAirPassengerticketbooks();
	}

	@Override
	public void setpassticket(AirPassengerticketbook apt) {
		passticbook.insertPassengerTicketBook(apt);
	}
}
