package com.example.demo.controller;

import java.security.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.FlightNotFoundException;
import com.example.demo.model.AirFlight;
import com.example.demo.model.AirJourney;
import com.example.demo.service.FlightService;





@CrossOrigin("*")
@RestController
@RequestMapping(path="/flight")
public class FlightController {

	@Autowired
	FlightService flightService;
	
	public FlightController() {
		System.out.println("FlightController()....");
		
	}
	
	
	@PostMapping(path="/admin/addFlight")
	public void addFlight(@RequestBody AirFlight flightToAdd) {
		
		AirFlight a1=(AirFlight)flightToAdd;
		AirJourney j1=a1.getAirJourney();
		
		flightService.insertFlightByAdminService(a1,j1);
	}
	@GetMapping(path="/admin/getFlights")
	public List<AirFlight> getAllFlights(){
		return flightService.selectAllFlightsService();
	}
//	@PutMapping(path = "/admin/updateFlight")
//	public void updateFlight(@RequestBody AirFlight flightToUpdate){
//		flightService.updateFlightByAdminService(flightToUpdate.getFlightId(), flightToUpdate);
//	}
//	@DeleteMapping(path= "/admin/deleteFlight/{fId}")
//	public void deleteFLight(@PathVariable("fId") long flightIdtoDelete) {
//		flightService.deleteFlightByAdminService(flightIdtoDelete);
//	}
//	
	
	@GetMapping(path="/getFlights/{source}/{destination}/{date}") 
	public List<AirFlight> getAllFlights(@PathVariable String source,@PathVariable String destination,@PathVariable String date ) {
		System.out.println("getAllFlights with source : "+ source+" destination : "+destination+" and date : "+date);
		
		return flightService.selectFlightsbyJourneyIdAndDepartureDateService(source, destination,date);
	}
	
	@GetMapping(path="/getFlight/{fId}") // localhost:8080/getDept/10
	public AirFlight getFlight(@PathVariable("fId") int flightToFind) throws FlightNotFoundException 
	{
		System.out.println("getFlight : "+flightToFind);
		AirFlight foundFlight = flightService.selectFlightByIdService(flightToFind);
	
		if(foundFlight == null) {
			throw new FlightNotFoundException("Flight Number Not Found "+flightToFind);
		}
		return foundFlight;
	}
	
	@PutMapping(path = "/updateFlight/{fId}")
	public void updateFlight(@PathVariable int fId, @PathVariable int economySeatsBooked, @PathVariable int businessSeatsBooked){
		flightService.updateFlightForFlightSeats(fId,economySeatsBooked, businessSeatsBooked);
	}
}