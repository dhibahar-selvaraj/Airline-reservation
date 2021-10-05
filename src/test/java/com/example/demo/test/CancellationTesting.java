package com.example.demo.test;
import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.CancellationRepository.CancellationRepositoryImpl;
import com.example.demo.layer3.TransactionReository.TransactionRepositoryImpl;
import com.example.demo.model.AirCancellation;
import com.example.demo.model.AirTransaction;




@SpringBootTest
public class CancellationTesting {
	
	CancellationRepositoryImpl tranrepo;
	
	@Test
	public void selectCancellation() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		tranrepo  = (CancellationRepositoryImpl ) ctx.getBean("cancellationrepo");
		AirCancellation tr=tranrepo.selectCancellationbyid(132);
		System.out.println(tr.getCancellationId());
		System.out.println(tr.getCancellationStatus());
		System.out.println(tr.getAirTransaction());
		System.out.println("--------------");
	}
	
	@Test
	public void selectallCancellation() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		System.out.println("hii");
		tranrepo  =   ctx.getBean("cancellationrepo",CancellationRepositoryImpl.class);
		System.out.println("hello");
		List<AirCancellation> tranlist=tranrepo.selectAllCancellation();
		for(AirCancellation tr: tranlist) {
			System.out.println(tr.getCancellationId());
			System.out.println(tr.getCancellationStatus());
			System.out.println(tr.getAirTransaction());
			System.out.println("--------------");
		}
	}
	@Test
	public void addNewCancellation() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		tranrepo  = (CancellationRepositoryImpl ) ctx.getBean("cancellationrepo");
		TransactionRepositoryImpl tranrep1  = (TransactionRepositoryImpl ) ctx.getBean("transactionrepo");
		AirCancellation dept=new AirCancellation();
		AirTransaction at=tranrep1.selectTransactionbyid(48);
		dept.setCancellationId(132);
		dept.setCancellationReason("medical");
		dept.setCancellationStatus("Success");
		dept.setRefundAmount(1234);
		dept.setAirTransaction(at);
		
		tranrepo.insertCancellation(dept);
		System.out.println(dept.getCancellationId());
	}
	@Test
	public void updateCancellationTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		tranrepo  = (CancellationRepositoryImpl ) ctx.getBean("cancellationrepo");
		AirCancellation dept=tranrepo.selectCancellationbyid(132);
		dept.setCancellationStatus("pending");
		tranrepo.updatecancellation(dept);
	}
	@Test
	public void deleteDepartmentTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		tranrepo  = (CancellationRepositoryImpl ) ctx.getBean("cancellationrepo");
		tranrepo.deleteCancellation(132);
	}
	
}
