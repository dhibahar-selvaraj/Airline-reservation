package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer3.PassengerRepository.PassengerRepositoryImpl;
import com.example.demo.layer3.PassengerTicketBookRepository.PassengerTicketBookRepositoryImpl;
import com.example.demo.model.AirPassenger;
import com.example.demo.model.AirPassengerticketbook;
import com.example.demo.model.AirPassengerticketbookPK;
import com.example.demo.model.temppassengerticketbook;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	PassengerTicketBookRepositoryImpl pskrepo;
	
	@Autowired
	PassengerRepositoryImpl passrepo;
	
	@Override
	public void setpassticketbook(temppassengerticketbook psk) {
		AirPassengerticketbook ap=new AirPassengerticketbook();
		AirPassengerticketbookPK apk=new AirPassengerticketbookPK();
		apk.setPassengerId(psk.getPassengerId());
		apk.setTicketId(psk.getTicketId());
		ap.setId(apk);
		ap.setSeatNumber(psk.getSeatNumber());
		pskrepo.insertPassengerTicketBook(ap);
	}

	@Override
	public AirPassenger addpassenger(AirPassenger ap) {
		passrepo.insertPassenger(ap);
		return ap;
	}

	@Override
	public List<AirPassenger> getpassengers() {
		return passrepo.selectAllPassenger();
	}

}
