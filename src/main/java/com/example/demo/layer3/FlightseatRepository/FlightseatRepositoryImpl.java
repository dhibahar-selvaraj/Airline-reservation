package com.example.demo.layer3.FlightseatRepository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.BaseRepository;
import com.example.demo.model.AirFlightseat;



@Repository("flightseatrepo")
public class FlightseatRepositoryImpl extends BaseRepository implements FlightseatRepository {

	public FlightseatRepositoryImpl() {
		System.out.println("TransactionRepositoryImpl().....");
	}
	
	@Transactional
	public void insertFlightseat(AirFlightseat dRef) {
		super.persist(dRef);
	}

	@Transactional
	public AirFlightseat selectFlightseatbyid(int dno) {
		return super.find(AirFlightseat.class, dno);
	}

	@Transactional
	public List<AirFlightseat> selectAllFlightseat() {
		System.out.println("selectall done");
		return super.findAll("AirFlightseat");
	}

	@Transactional
	public void updateFlightseat(AirFlightseat dRef) {
		super.merge(dRef);
	}

	@Transactional
	public void deleteFlightseat(int dno) {
		super.remove(AirFlightseat.class, dno);
	}

}
