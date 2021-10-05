package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.AirJourney;


@Service
public interface JourneyService {
	
	
	public List<AirJourney> selectAllJourneyService();
	public AirJourney selectJourneyByIdService(long journeyIdToFind);
	public AirJourney selectJourneyBySourceDestinationService(String source, String destination);
	public List<String> selectAllSourceCities();
	public List<String> selectAllDestinationCities();
	public void updateJourneyService(long journeyToUpdate, AirJourney updatedJourney);
	public void deleteJourneyService(long journeyToDelete);

}
