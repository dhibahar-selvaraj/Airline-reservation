package com.example.demo.layer3.PassengerTicketBookRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AirPassengerticketbook;
import com.example.demo.model.AirPassengerticketbookPK;



@Repository
public interface PassengerTicketBookRepository { //DAO is known as Repository framework
	void insertPassengerTicketBook(AirPassengerticketbook dRef);
	AirPassengerticketbook selectPassengerTicketBook( AirPassengerticketbookPK pk);
	List<AirPassengerticketbook> selectAllPassengerTicketBook();
	void updatePassengerTicketBook(AirPassengerticketbook dRef);
	void deletePassengerTicketBook(AirPassengerticketbookPK pk);
}
//interface DeptRepository cannot be instantiated
//but the child of this interface can be innstantiated
