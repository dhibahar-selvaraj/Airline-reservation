package com.example.demo.layer3.FlightRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AirFlight;




@Repository
public interface FlightRepository { //DAO is known as Repository framework
	void insertFlight(AirFlight dRef);
	AirFlight findFlight(int dno);
	List<AirFlight> findAllFlights(String whereQuery);
	void updateFlight(AirFlight dRef);
	void deleteFlight(int dno);
}
//interface DeptRepository cannot be instantiated
//but the child of this interface can be innstantiated
//void insertFlight(AirFlight Aref);
//List<AirFlight> findAllFlights(String whereQuery);
//AirFlight findFlight(long l);
//void updateFlight(AirFlight Aref);
//void deleteFlight(long idToDelete);