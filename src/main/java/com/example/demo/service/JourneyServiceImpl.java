package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.FlightNotFoundException;
import com.example.demo.layer3.JourneyRepository.JourneyRepository;
import com.example.demo.model.AirJourney;


@Service
public class JourneyServiceImpl implements JourneyService {

	@Autowired
	JourneyRepository journeyRepo;
	
	public List<AirJourney> selectAllJourneyService() {
		return journeyRepo.findAllJourneys("AirJourney");
	}
	
	public AirJourney selectJourneyByIdService(long journeyIdToFind) {
			return journeyRepo.findJourneyById(journeyIdToFind);
	}
	
	public AirJourney selectJourneyBySourceDestinationService(String source, String destination) {
		return journeyRepo.findJourneyId(source, destination);
	}
	

	public List<String> selectAllSourceCities() {
		List<AirJourney> journeyList = journeyRepo.findAllJourneys("AirJourney");
		Set<String> Cities= new HashSet<String>();
		List<String> sourceCities= new ArrayList<>();
		for(AirJourney journey: journeyList) {
			Cities.add(journey.getSourceLoc().toUpperCase());
		}
		for(String city: Cities)
			sourceCities.add(city);
			
		return sourceCities;
	}
	
	public List<String> selectAllDestinationCities() {
		List<AirJourney> journeyList = journeyRepo.findAllJourneys("AirJourney");
		Set<String> Cities= new HashSet<String>();
		List<String> destinationCities= new ArrayList<>();
		for(AirJourney journey: journeyList) {
			Cities.add(journey.getDestinationLoc().toUpperCase());
		}
		for(String city: Cities)
			destinationCities.add(city);
		return  destinationCities;
	}

	public void updateJourneyService(long journeyToUpdate, AirJourney updatedJourney) {
		
			if(updatedJourney==null)
			{
				throw new FlightNotFoundException("Flight Not Found");
			}
			else
				journeyRepo.updateJourney(updatedJourney);
	}

	public void deleteJourneyService(long journeyToDelete) {
		if(journeyRepo.findJourneyById(journeyToDelete)==null)
		{
			throw new FlightNotFoundException("Flight Not Found");
		}
		else
		journeyRepo.deleteJourney(journeyToDelete);
	}

}
