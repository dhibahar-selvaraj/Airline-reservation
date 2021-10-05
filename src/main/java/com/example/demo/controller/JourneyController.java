package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AirJourney;
import com.example.demo.service.JourneyService;


@CrossOrigin(origins = "*", value = "*")
@RestController
@RequestMapping(path="/journey")
public class JourneyController {
	
	@Autowired
	JourneyService journeyService;
	
	public JourneyController() {
		System.out.println("JourneyController()....");
		
	}
	
	@GetMapping(path="/getJourneys")
	public List<AirJourney> getAllJourneys(){
		return journeyService.selectAllJourneyService();	
	}
	
	@GetMapping(path="/getSourceCities")
	public List<String> getAllSourceCities(){
		return journeyService.selectAllSourceCities();	
	}
	
	@GetMapping(path="/getDestinationCities")
	public List<String> getAllDestinationCities(){
		return journeyService.selectAllDestinationCities();	
	}
	
	@PutMapping(path="/updateJourney")
	public void updateJourney(@RequestBody AirJourney journeyToUpdate) {
		journeyService.updateJourneyService(journeyToUpdate.getJourneyId(), journeyToUpdate);
	}

}
