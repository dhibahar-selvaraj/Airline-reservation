package com.example.demo.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.FlightNotAvailableForBookingException;
import com.example.demo.Exceptions.FlightNotFoundException;
import com.example.demo.model.AirFlight;
import com.example.demo.model.AirJourney;



@Service
public interface FlightService {
	
	public AirFlight selectFlightByIdService(int flightId);
	public List<AirFlight> selectFlightsbyJourneyIdAndDepartureDateService(String source, String destination, String date);
	public List<AirFlight> selectAllFlightsService();
	public void insertFlightByAdminService(AirFlight flightToInsert, AirJourney journeyToInsert);
	public void updateFlightByAdminService(int flightId, AirFlight updatedFlight) throws FlightNotFoundException;
	public void updateFlightForFlightSeats(int flightId, int economySeats, int businessSeats) throws FlightNotFoundException,FlightNotAvailableForBookingException;
	public void deleteFlightByAdminService(int idToDelete) throws FlightNotFoundException;
}
