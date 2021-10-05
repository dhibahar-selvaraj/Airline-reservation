package com.example.demo.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.layer3.PassengerTicketBookRepository.PassengerTicketBookRepositoryImpl;
import com.example.demo.model.AirPassengerticketbook;
import com.example.demo.model.AirPassengerticketbookPK;

@SpringBootTest
public class Passengerticketbooktest {
	PassengerTicketBookRepositoryImpl passticketrepo;
	@Test
	public void selectallBooking() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		passticketrepo  = (PassengerTicketBookRepositoryImpl ) ctx.getBean("passticketbookrepo");
		List<AirPassengerticketbook> tranlist=passticketrepo.selectAllPassengerTicketBook();
		for(AirPassengerticketbook tr: tranlist) {
			System.out.println(tr.getSeatNumber());
			System.out.println(tr.getAirBooking().getBookingId());
			System.out.println(tr.getAirPassenger().getFirstName());
			System.out.println("--------------");
		}
	}
	
	@Test
	public void selectBooking() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		passticketrepo  = (PassengerTicketBookRepositoryImpl ) ctx.getBean("passticketbookrepo");
		AirPassengerticketbookPK apk=new AirPassengerticketbookPK(); 
		apk.setPassengerId(1005);
		apk.setTicketId(133);
		AirPassengerticketbook tr=passticketrepo.selectPassengerTicketBook(apk);
		System.out.println(tr.getSeatNumber());
		System.out.println(tr.getAirBooking().getBookingId());
		System.out.println(tr.getAirPassenger().getFirstName());
		System.out.println("--------------");
	}
	
	@Test
	public void addNewpassbookTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		passticketrepo  = (PassengerTicketBookRepositoryImpl ) ctx.getBean("passticketbookrepo");
		AirPassengerticketbook ap=new AirPassengerticketbook();
		AirPassengerticketbookPK apk=new AirPassengerticketbookPK(); 
		apk.setPassengerId(1005);
		apk.setTicketId(134);
		ap.setId(apk);
		passticketrepo.insertPassengerTicketBook(ap);
	}
	
	@Test
	public void deletepassbookTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		passticketrepo  = (PassengerTicketBookRepositoryImpl ) ctx.getBean("passticketbookrepo");
		AirPassengerticketbookPK apk=new AirPassengerticketbookPK(); 
		apk.setPassengerId(1001);
		apk.setTicketId(134);
		passticketrepo.deletePassengerTicketBook(apk);
	}
}
