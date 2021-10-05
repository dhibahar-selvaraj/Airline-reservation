package com.example.demo.layer3.JourneyRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AirJourney;




@Repository
public interface JourneyRepository { //DAO is known as Repository framework
	AirJourney findJourneyId(String source, String destination);
	AirJourney findJourneyById(long Id);
	void insertJourney(AirJourney Jref);
	void updateJourney(AirJourney Jref);
	void deleteJourney(long journeyToDelete);
	List<AirJourney> findAllJourneys(String pojo);
}
//interface DeptRepository cannot be instantiated
//but the child of this interface can be innstantiated
