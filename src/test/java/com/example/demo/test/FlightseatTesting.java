package com.example.demo.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.FlightseatRepository.FlightseatRepositoryImpl;
import com.example.demo.model.AirFlightseat;



@SpringBootTest
public class FlightseatTesting {

	FlightseatRepositoryImpl afrepo;
	@Test
	public void selectallFlightseat() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  =   ctx.getBean("flightseatrepo",FlightseatRepositoryImpl.class);
		List<AirFlightseat> tranlist=afrepo.selectAllFlightseat();
		for(AirFlightseat tr: tranlist) {
			System.out.println(tr.getSeatNumber());
			System.out.println(tr.getSeatType());
			System.out.println(tr.getClass());
			System.out.println("--------------");
		}
	}
	@Test
	public void selectFlightseat() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (FlightseatRepositoryImpl ) ctx.getBean("flightseatrepo");
		AirFlightseat tr=afrepo.selectFlightseatbyid(11);
		System.out.println(tr.getSeatNumber());
		System.out.println(tr.getSeatType());
		System.out.println(tr.getClass());
		System.out.println("--------------");
	}
	
	@Test
	public void addFlightseat() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (FlightseatRepositoryImpl ) ctx.getBean("flightseatrepo");
		AirFlightseat dept=new AirFlightseat();
		dept.setSeatType("economy");
		dept.setSeatNumber(23);
		afrepo.insertFlightseat(dept);
	}
	
	@Test
	public void updateFlightTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (FlightseatRepositoryImpl ) ctx.getBean("flightseatrepo");
		AirFlightseat dept=afrepo.selectFlightseatbyid(23);
		dept.setSeatType("bussiness");
		afrepo.updateFlightseat(dept);
	}
	@Test
	public void deleteFlightTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (FlightseatRepositoryImpl ) ctx.getBean("flightseatrepo");
		afrepo.deleteFlightseat(23);
	}
}
