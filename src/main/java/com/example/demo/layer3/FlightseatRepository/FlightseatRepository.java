package com.example.demo.layer3.FlightseatRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AirFlightseat;




@Repository
public interface FlightseatRepository { //DAO is known as Repository framework
	void insertFlightseat(AirFlightseat dRef);
	AirFlightseat selectFlightseatbyid(int dno);
	List<AirFlightseat> selectAllFlightseat();
	void updateFlightseat(AirFlightseat dRef);
	void deleteFlightseat(int dno);
}
//interface DeptRepository cannot be instantiated
//but the child of this interface can be innstantiated
