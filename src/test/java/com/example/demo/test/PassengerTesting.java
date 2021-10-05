package com.example.demo.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.PassengerRepository.PassengerRepositoryImpl;
import com.example.demo.model.AirPassenger;


@SpringBootTest
public class PassengerTesting {

	PassengerRepositoryImpl afrepo;
	@Test
	public void selectallPassenger() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  =   ctx.getBean("passengerrepo",PassengerRepositoryImpl.class);
		List<AirPassenger> tranlist=afrepo.selectAllPassenger();
		for(AirPassenger tr: tranlist) {
			System.out.println(tr.getFirstName());
			System.out.println(tr.getGender());
			System.out.println(tr.getLastName());
			System.out.println(tr.getPassengerId());
			System.out.println("--------------");
		}
	}
	@Test
	public void selectPassenger() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (PassengerRepositoryImpl ) ctx.getBean("passengerrepo");
		AirPassenger tr=afrepo.selectPassengerbyid(1005);
		System.out.println(tr.getFirstName());
		System.out.println(tr.getGender());
		System.out.println(tr.getLastName());
		System.out.println(tr.getPassengerId());
		System.out.println("--------------");
	}
	
	@Test
	public void addPassenger() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (PassengerRepositoryImpl ) ctx.getBean("passengerrepo");
		BigDecimal d=new BigDecimal("1234567890");
		AirPassenger dept=new AirPassenger();
		dept.setFirstName("mani");
		dept.setLastName("khan");
		dept.setGender("m");
		afrepo.insertPassenger(dept);
		System.out.println(dept.getPassengerId());
	}
	
	@Test
	public void updatePassengerTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (PassengerRepositoryImpl ) ctx.getBean("passengerrepo");
		AirPassenger dept=afrepo.selectPassengerbyid(60);
		dept.setFirstName("domar");
		afrepo.updatePassenger(dept);
	}
	@Test
	public void deletePassengerTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (PassengerRepositoryImpl ) ctx.getBean("passengerrepo");
		afrepo.deletePassenger(60);
	}
}
