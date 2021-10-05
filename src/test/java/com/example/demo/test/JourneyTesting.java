package com.example.demo.test;
import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.JourneyRepository.JourneyRepositoryImpl;
import com.example.demo.model.AirJourney;

@SpringBootTest
public class JourneyTesting {

	JourneyRepositoryImpl afrepo;
	@Test
	public void selectallJourney() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  =   ctx.getBean("journeyrepo",JourneyRepositoryImpl.class);
		List<AirJourney> tranlist=afrepo.findAllJourneys("AirJourney");
		for(AirJourney tr: tranlist) {
			System.out.println(tr.getSourceLoc());
			System.out.println(tr.getDestinationLoc());
			System.out.println(tr.getJourneyId());
			System.out.println("--------------");
		}
	}
	@Test
	public void selectJourney() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (JourneyRepositoryImpl ) ctx.getBean("journeyrepo");
		AirJourney tr=afrepo.findJourneyById(6);
		System.out.println(tr.getSourceLoc());
		System.out.println(tr.getDestinationLoc());
		System.out.println(tr.getJourneyId());
		System.out.println("--------------");
	}
	
	@Test
	public void addJourney() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (JourneyRepositoryImpl ) ctx.getBean("journeyrepo");
		AirJourney dept=new AirJourney();
		dept.setDestinationLoc("london");
		dept.setSourceLoc("paris");
		afrepo.insertJourney(dept);
		System.out.println(dept.getJourneyId());
	}
	
	@Test
	public void updateJourneyTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (JourneyRepositoryImpl ) ctx.getBean("journeyrepo");
		AirJourney dept=afrepo.findJourneyById(23);
		dept.setDestinationLoc("china");
		afrepo.updateJourney(dept);
	}
	@Test
	public void deleteJourneyTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (JourneyRepositoryImpl ) ctx.getBean("journeyrepo");
		afrepo.deleteJourney(61);
	}
}
