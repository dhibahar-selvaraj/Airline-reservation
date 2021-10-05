package com.example.demo.layer3.TransactionReository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.BaseRepository;
import com.example.demo.model.AirTransaction;



@Repository("transactionrepo")
public class TransactionRepositoryImpl extends BaseRepository implements TransactionRepository {

	public TransactionRepositoryImpl() {
		System.out.println("TransactionRepositoryImpl().....");
	}
	
	@Transactional
	public void insertTransaction(AirTransaction dRef) {
		super.persist(dRef);
		System.out.println(dRef.getTransactionId());
	}

	@Transactional
	public AirTransaction selectTransactionbyid(int dno) {
		return super.find(AirTransaction.class, dno);
	}

	@Transactional
	public List<AirTransaction> selectAllTransacion() {
		System.out.println("selectall done");
		return super.findAll("AirTransaction");
	}
	
	@Transactional
	public void updateTransaction(AirTransaction dRef) {
		super.merge(dRef);
	}
	
	@Transactional
	public void deleteTransaction(int dno) {
		super.remove(AirTransaction.class, dno);
	}

}
