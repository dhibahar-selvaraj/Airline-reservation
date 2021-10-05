package com.example.demo.layer3.PassengerRepository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.BaseRepository;
import com.example.demo.model.AirPassenger;



@Repository("passengerrepo")
public class PassengerRepositoryImpl extends BaseRepository implements PassengerRepository {

	public PassengerRepositoryImpl() {
		System.out.println("TransactionRepositoryImpl().....");
	}
	
	@Transactional
	public void insertPassenger(AirPassenger dRef) {
		super.persist(dRef);
	}

	@Transactional
	public AirPassenger selectPassengerbyid(int dno) {
		return super.find(AirPassenger.class, dno);
	}

	@Transactional
	public List<AirPassenger> selectAllPassenger() {
		System.out.println("selectall done");
		return super.findAll("AirPassenger");
	}

	@Transactional
	public void updatePassenger(AirPassenger dRef) {
		super.merge(dRef);
	}

	@Transactional
	public void deletePassenger(int dno) {
		super.remove(AirPassenger.class, dno);
	}

}
