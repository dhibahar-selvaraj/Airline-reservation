package com.example.demo.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.FlightRepository.FlightRepositoryImpl;
import com.example.demo.model.AirFlight;
import com.example.demo.model.AirJourney;

@SpringBootTest
public class flightTesting {
	FlightRepositoryImpl afrepo;
	@Test
	public void selectallFlight() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  =   ctx.getBean("flightrepo",FlightRepositoryImpl.class);
		List<AirFlight> tranlist=afrepo.findAllFlights("AirFlight");
		for(AirFlight tr: tranlist) {
			System.out.println(tr.getFlightName());
			System.out.println(tr.getFlightStatus());
			System.out.println(tr.getAirJourney().getSourceLoc());
			System.out.println("--------------");
		}
	}
	@Test
	public void selectflight() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (FlightRepositoryImpl ) ctx.getBean("flightrepo");
		AirFlight tr=afrepo.findFlight(101);
		System.out.println(tr.getFlightName());
		System.out.println(tr.getFlightStatus());
		System.out.println(tr.getAirJourney().getSourceLoc());
		System.out.println("--------------");
	}
	
	@Test
	public void addFlight() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (FlightRepositoryImpl ) ctx.getBean("flightrepo");
		
		AirJourney dept=new AirJourney();
		AirFlight af=new AirFlight();
		af.setAvailableBussinessSeats(10);
		af.setAvailableEconomySeats(10);
		af.setBussinessClassPrice(1000);
		af.setEconomyClassPrice(2000);
		afrepo.insertFlight(af);
		System.out.println(af.getFlightId());
	}
	
	@Test
	public void updateFlightTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (FlightRepositoryImpl ) ctx.getBean("flightrepo");
		AirFlight dept=afrepo.findFlight(58);
		dept.setBussinessClassPrice(2500);
		afrepo.updateFlight(dept);
	}
	@Test
	public void deleteFlightTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (FlightRepositoryImpl ) ctx.getBean("flightrepo");
		afrepo.deleteFlight(58);
	}
}
