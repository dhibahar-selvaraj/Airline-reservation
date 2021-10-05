package com.example.demo.layer3.PassengerRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AirPassenger;




@Repository
public interface PassengerRepository { //DAO is known as Repository framework
	void insertPassenger(AirPassenger dRef);
	AirPassenger selectPassengerbyid(int dno);
	List<AirPassenger> selectAllPassenger();
	void updatePassenger(AirPassenger dRef);
	void deletePassenger(int dno);
}
//interface DeptRepository cannot be instantiated
//but the child of this interface can be innstantiated
