package com.example.demo.layer3.CancellationRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AirCancellation;



@Repository
public interface CancellationRepository { //DAO is known as Repository framework
	void insertCancellation(AirCancellation dRef);
	AirCancellation selectCancellationbyid(int dno);
	List<AirCancellation> selectAllCancellation();
	void updatecancellation(AirCancellation dRef);
	void deleteCancellation(int dno);
}
//interface DeptRepository cannot be instantiated
//but the child of this interface can be innstantiated
