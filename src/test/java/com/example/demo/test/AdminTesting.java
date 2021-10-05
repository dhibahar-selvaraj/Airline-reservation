package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.layer3.AdminRepository.AdminRepositoryImpl;
import com.example.demo.model.AirAdmin;


@SpringBootTest
public class AdminTesting {
	
	AdminRepositoryImpl afrepo;
	
	@Test
	public void selectAdmin() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		afrepo  = (AdminRepositoryImpl ) ctx.getBean("adminrepo");
		AirAdmin tr=afrepo.selectAdminbyid("1234");
		System.out.println(tr.getAdminId());
		System.out.println(tr.getAdminPassword());
		System.out.println("--------------");
	}
}
