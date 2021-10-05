package com.example.demo.layer3.PassengerTicketBookRepository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.BaseRepository;
import com.example.demo.model.AirPassengerticketbook;
import com.example.demo.model.AirPassengerticketbookPK;



@Repository("passticketbookrepo")
public class PassengerTicketBookRepositoryImpl extends BaseRepository implements PassengerTicketBookRepository {

	public PassengerTicketBookRepositoryImpl() {
		System.out.println("PassengerTicketBookRepositoryImpl().....");
	}
	
	@Transactional
	public void insertPassengerTicketBook(AirPassengerticketbook dRef) {
		super.persist(dRef);
	}

	@Transactional
	public AirPassengerticketbook selectPassengerTicketBook(AirPassengerticketbookPK pk) {
		return super.find(AirPassengerticketbook.class, pk);
	}

	@Transactional
	public List<AirPassengerticketbook> selectAllPassengerTicketBook() {
		System.out.println("selectall done");
		return super.findAll("AirPassengerticketbook");
	}

	@Transactional
	public void updatePassengerTicketBook(AirPassengerticketbook dRef) {
		super.merge(dRef);
	}

	@Transactional
	public void deletePassengerTicketBook(AirPassengerticketbookPK pk) {
		super.remove(AirPassengerticketbook.class, pk);
	}


	
	




}
