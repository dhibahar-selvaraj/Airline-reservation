package com.example.demo.test;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.TransactionReository.TransactionRepositoryImpl;
import com.example.demo.model.AirTransaction;


@SpringBootTest
public class TransactionTesting {
	
	TransactionRepositoryImpl tranrepo;
	
	@Test
	public void selectTransaction() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		tranrepo  = (TransactionRepositoryImpl ) ctx.getBean("transactionrepo");
		AirTransaction tr=tranrepo.selectTransactionbyid(223);
		System.out.println(tr.getTransactionId());
		System.out.println(tr.getTransactionMode());
		System.out.println(tr.getTransactionStatus());
		System.out.println("--------------");
	}
	
	@Test
	public void selectallTransaction() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		System.out.println("hii");
		tranrepo  =   ctx.getBean("transactionrepo",TransactionRepositoryImpl.class);
		System.out.println("hello");
		List<AirTransaction> tranlist=tranrepo.selectAllTransacion();
		for(AirTransaction tr: tranlist) {
			System.out.println(tr.getTransactionId());
			System.out.println(tr.getTransactionMode());
			System.out.println(tr.getTransactionStatus());
			System.out.println("--------------");
		}
	}
	@Test
	public void addNewTransactionTest() {
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("springconfig.xml");
		tranrepo  = (TransactionRepositoryImpl ) ctx.getBean("transactionrepo");
		AirTransaction dept=new AirTransaction();
		dept.setTransactionAmount(1);
		dept.setTransactionMode("credit card");
		dept.setTransactionStatus("success");
		dept.setTransactionType("c");
		tranrepo.insertTransaction(dept);
		System.out.println(dept.getTransactionId());
	}
}
