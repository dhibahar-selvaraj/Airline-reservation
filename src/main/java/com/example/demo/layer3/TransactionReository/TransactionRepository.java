package com.example.demo.layer3.TransactionReository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AirTransaction;



@Repository
public interface TransactionRepository { //DAO is known as Repository framework
	void insertTransaction(AirTransaction dRef);
	AirTransaction selectTransactionbyid(int dno);
	List<AirTransaction> selectAllTransacion();
	void updateTransaction(AirTransaction dRef);
	void deleteTransaction(int dno);
}
//interface DeptRepository cannot be instantiated
//but the child of this interface can be innstantiated
