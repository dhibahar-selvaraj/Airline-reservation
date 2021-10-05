package com.example.demo.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.UserRepository.UserRepositoryImpl;
import com.example.demo.model.AirUser;


@SpringBootTest
public class UserTesting {

	UserRepositoryImpl afrepo;
	@Test
	public void selectallUser() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  =   ctx.getBean("userrepo",UserRepositoryImpl.class);
		List<AirUser> tranlist=afrepo.findAll("AirUser");
		for(AirUser tr: tranlist) {
			System.out.println(tr.getUserId());
			System.out.println(tr.getEmailId());
			System.out.println(tr.getFirstName());
			System.out.println(tr.getLastName());
			System.out.println("--------------");
		}
	}
	@Test
	public void selectflight() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (UserRepositoryImpl ) ctx.getBean("userrepo");
		AirUser tr=afrepo.SelectUserById(101);
		System.out.println(tr.getUserId());
		System.out.println(tr.getEmailId());
		System.out.println(tr.getFirstName());
		System.out.println(tr.getLastName());
		System.out.println("--------------");
	}
	
	@Test
	public void addUser() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (UserRepositoryImpl ) ctx.getBean("userrepo");
		BigDecimal d=new BigDecimal("1234567890");
		AirUser dept=new AirUser();
		dept.setEmailId("hello@gmail.com");
		dept.setFirstName("john");
		dept.setLastName("wick");
		dept.setPassword("hfb");
		dept.setPhNo(d);
		afrepo.insertUser(dept);
		System.out.println(dept.getUserId());
	}
	
	@Test
	public void updateFlightTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (UserRepositoryImpl ) ctx.getBean("userrepo");
		AirUser dept=afrepo.SelectUserById(59);
		dept.setFirstName("domar");
		afrepo.updateUser(dept);
	}
	@Test
	public void deleteFlightTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (UserRepositoryImpl ) ctx.getBean("userrepo");
		afrepo.deleteUser(59);
	}
}
