package com.example.demo.test;
import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.layer3.BookingRepository.BookingRepositoryImpl;
import com.example.demo.model.AirBooking;

@SpringBootTest
public class BookingTesting {

	BookingRepositoryImpl bookrepo;
	@Test
	public void selectBooking() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		bookrepo  = (BookingRepositoryImpl ) ctx.getBean("bookingrepo");
		AirBooking tr=bookrepo.selectBookingbyid(132);
		System.out.println(tr.getBookingId());
		System.out.println(tr.getBookingStatus());
		System.out.println(tr.getJourneyType());
		System.out.println(tr.getBookingDate());
		System.out.println("--------------");
	}
	
	@Test
	public void selectallBooking() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		bookrepo  = (BookingRepositoryImpl ) ctx.getBean("bookingrepo");
		List<AirBooking> tranlist=bookrepo.selectAllBooking();
		for(AirBooking tr: tranlist) {
			System.out.println(tr.getBookingId());
			System.out.println(tr.getBookingStatus());
			System.out.println(tr.getJourneyType());
			System.out.println(tr.getBookingDate());
			System.out.println("--------------");
		}
	}
	
	@Test
	public void addNewBookingTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		bookrepo  = (BookingRepositoryImpl ) ctx.getBean("bookingrepo");
		AirBooking dept=new AirBooking();
		dept.setBookingStatus("success");
		dept.setTotalCost(12345);
		dept.setBussinessSeatsBooked(2);
		dept.setEconomySeatsBooked(2);
		bookrepo.insertBooking(dept);
		System.out.println(dept.getBookingId());
	}
	
	@Test
	public void updateBookingTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		bookrepo  = (BookingRepositoryImpl ) ctx.getBean("bookingrepo");
		AirBooking dept=bookrepo.selectBookingbyid(57);
		dept.setBookingStatus("Cancelled");
		dept.setBookingDate(new Timestamp(new java.util.Date().getTime()));
		bookrepo.updateBooking(dept);
	}
}
