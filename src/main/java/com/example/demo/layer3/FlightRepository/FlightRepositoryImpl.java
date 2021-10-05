package com.example.demo.layer3.FlightRepository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.BaseRepository;
import com.example.demo.model.AirFlight;



@Repository("flightrepo")
public class FlightRepositoryImpl extends BaseRepository implements FlightRepository {

	public FlightRepositoryImpl() {
		System.out.println("TransactionRepositoryImpl().....");
	}
	
	@Transactional
	public void insertFlight(AirFlight dRef) {
		super.persist(dRef);
	}

	@Transactional
	public AirFlight findFlight(int dno) {
		return super.find(AirFlight.class, dno);
	}
	
	@Transactional
	public List<AirFlight> findAllFlights(String whereQuery) {
		System.out.println("selectall done");
		System.out.println(whereQuery);
		return super.findAll(whereQuery);
	}

	@Transactional
	public void updateFlight(AirFlight dRef) {
		super.merge(dRef);
	}

	@Transactional
	public void deleteFlight(int dno) {
		super.remove(AirFlight.class, dno);
	}



}
