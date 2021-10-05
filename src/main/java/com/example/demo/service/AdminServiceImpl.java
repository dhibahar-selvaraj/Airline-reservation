package com.example.demo.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.FlightNotFoundException;
import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.layer3.AdminRepository.AdminRepository;
import com.example.demo.layer3.BookingRepository.BookingRepositoryImpl;
import com.example.demo.layer3.CancellationRepository.CancellationRepositoryImpl;
import com.example.demo.layer3.FlightRepository.FlightRepository;
import com.example.demo.layer3.FlightRepository.FlightRepositoryImpl;
import com.example.demo.layer3.PassengerTicketBookRepository.PassengerTicketBookRepository;
import com.example.demo.layer3.TransactionReository.TransactionRepositoryImpl;
import com.example.demo.model.AirAdmin;
import com.example.demo.model.AirBooking;
import com.example.demo.model.AirCancellation;
import com.example.demo.model.AirFlight;
import com.example.demo.model.AirPassengerticketbook;
import com.example.demo.model.AirTransaction;
import com.example.demo.model.AirUser;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	NewBookingServiceImpl bookservice;

	@Autowired
	BookingRepositoryImpl bookrepo;
	
	@Autowired
	TransactionRepositoryImpl tr;
	
	@Autowired
	PassengerTicketBookRepository pskrepo;
	
	@Autowired
	FlightRepositoryImpl frepo;
	
	@Autowired
	CancellationRepositoryImpl cancelrepo;
	
	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	AdminRepository adminRepo;
	
	
	@Override
	public void deleteflight(AirFlight af) {
		AirFlight newflight=frepo.findFlight((int)af.getFlightId());
		List<AirBooking> ab=newflight.getAirBookings();
		for(AirBooking curr:ab) {
			bookservice.cancelBooking(curr);
			AirCancellation ac=cancelrepo.selectCancellationbyid(curr.getBookingId());
			ac.setCancellationReason("cancelled by admin");
			cancelrepo.insertCancellation(ac);
		}
	}

	
	@Override
	public List<AirFlight> getallflights() {
		return frepo.findAllFlights("AirFlight e where e.flightStatus='available'");
	}

	@Override
	public void insertflight(AirFlight af) {
		frepo.insertFlight(af);
	}
	
	
public void cancelFlightByAdminService(int flightId)throws FlightNotFoundException {
	
		if(flightRepo.findFlight(flightId)==null)
		{
			throw new FlightNotFoundException("Flight Not Found");
		}
		else
			{
			AirFlight cancelledFlight=flightRepo.findFlight(flightId);
				cancelledFlight.setFlightStatus("Cancelled");
				flightRepo.updateFlight(cancelledFlight);
				List<AirBooking> ablist=cancelledFlight.getAirBookings();
				for(AirBooking ab: ablist) {
					if(ab.getBookingStatus()!="cancelled")
						this.admincancelBooking(ab);
				}
			}

}


@Override
public void admincancelBooking(AirBooking book) {
	AirBooking newbook = (AirBooking) book;
	newbook.setBookingStatus("cancelled");
	bookrepo.updateBooking(newbook);
	System.out.println("booking updated");
	AirTransaction at=new AirTransaction();
	at.setTransactionMode(newbook.getAirTransaction().getTransactionMode());
	at.setTransactionAmount(newbook.getTotalCost());
	at.setTransactionStatus("succeded");
	tr.insertTransaction(at);
	System.out.println("transaction updated");
	
	
	AirCancellation cancel=new AirCancellation();
	cancel.setAirTransaction(at);
	cancel.setCancellationId(newbook.getBookingId());
	cancel.setAirBooking(newbook);
	cancel.setCancellationReason("by admin");
	cancel.setRefundAmount(newbook.getTotalCost());
	Date d=new Date();
	cancel.setCancellationDate(new Timestamp(d.getTime()) );
	cancelrepo.insertCancellation(cancel);
	System.out.println("cancellation added");
	
	List<AirPassengerticketbook> aplist=newbook.getAirPassengerticketbooks();
	for(AirPassengerticketbook unit: aplist) {
			pskrepo.deletePassengerTicketBook(unit.getId());
	}
	System.out.println("seat is deleted");
}


@Override
public List<AirFlight> getallcancelledflights() {
	return frepo.findAllFlights("AirFlight e where e.flightStatus='Cancelled'");
}

public AirAdmin login(String id, String password)  {
	System.out.println("In Admin status");
	AirAdmin ad = adminRepo.selectAdminbyid(id);
	System.out.println(ad.getAdminPassword());
	if(ad==null) {
		return new AirAdmin();
	}
	System.out.println("found--1" + password);
	if( ad.getAdminPassword().equals(password)) {
		System.out.println("found" );
		  return ad;
	}
	return new AirAdmin();


}



}

