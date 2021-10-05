package com.example.demo.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.FlightNotAvailableForBookingException;
import com.example.demo.Exceptions.FlightNotFoundException;
import com.example.demo.layer3.FlightRepository.FlightRepository;
import com.example.demo.layer3.JourneyRepository.JourneyRepository;
import com.example.demo.model.AirFlight;
import com.example.demo.model.AirJourney;



@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepo;
	@Autowired
	JourneyRepository journeyRepo;
	
	
	public void insertFlightByAdminService(AirFlight flightToInsert,AirJourney journeyToInsert) {
		if(journeyRepo.findJourneyId(journeyToInsert.getSourceLoc(), journeyToInsert.getDestinationLoc())==null)
				journeyRepo.insertJourney(journeyToInsert);
		flightToInsert.setAirJourney(journeyRepo.findJourneyId(journeyToInsert.getSourceLoc(), journeyToInsert.getDestinationLoc()));
		flightRepo.insertFlight(flightToInsert);
	}
	
	
	public List<AirFlight> selectAllFlightsService(){
		return flightRepo.findAllFlights("AirFlight");	
	}
	
	
	public AirFlight selectFlightByIdService(int flightId) {
		return flightRepo.findFlight(flightId);
	}


	public List<AirFlight> selectFlightsbyJourneyIdAndDepartureDateService(String source, String destination, String Departure) {
		Date date=Date.valueOf(Departure);
		AirJourney journeyList = journeyRepo.findJourneyId(source, destination);
		String whereQuery="AirFlight where airJourney.journeyId =  "+ journeyList.getJourneyId()+ "and to_char(departure_dateTime,'YYYY-MM-DD') = '"+date+"'and availableEconomySeats+availableBussinessSeats>0 and flightStatus ='available' " ;
		return flightRepo.findAllFlights(whereQuery);
	}


	public void updateFlightByAdminService(int flightId, AirFlight updatedFlight) throws FlightNotFoundException {
				
		if(updatedFlight==null)
		{
			throw new FlightNotFoundException("Flight Not Found");
		}
		else
			flightRepo.updateFlight(updatedFlight);
	}

	
	public void updateFlightForFlightSeats(int flightId, int economySeats, int businessSeats) throws FlightNotFoundException,FlightNotAvailableForBookingException {
		
		if(flightRepo.findFlight(flightId)==null)
		{
			throw new FlightNotFoundException("Flight Not Found");
		}
		else
		{
			AirFlight updatedFlight = flightRepo.findFlight(flightId);
			if(updatedFlight.getAvailableEconomySeats()>=economySeats && updatedFlight.getAvailableBussinessSeats()>=businessSeats){
				updatedFlight.setAvailableBussinessSeats(updatedFlight.getAvailableBussinessSeats()-businessSeats);
				updatedFlight.setAvailableEconomySeats(updatedFlight.getAvailableEconomySeats()-economySeats);
				flightRepo.updateFlight(updatedFlight);
			}
			else
				throw new FlightNotAvailableForBookingException("Flight is full for Booking ");
		}
	}

	public void deleteFlightByAdminService(int flightId)throws FlightNotFoundException {
		
		if(flightRepo.findFlight(flightId)==null)
		{
			throw new FlightNotFoundException("Flight Not Found");
		}
		else
			flightRepo.deleteFlight(flightId);
	}
	
	
	



}
