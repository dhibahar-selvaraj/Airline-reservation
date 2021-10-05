package com.example.demo.layer3.CancellationRepository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.BaseRepository;
import com.example.demo.model.AirCancellation;



@Repository("cancellationrepo")
public class CancellationRepositoryImpl extends BaseRepository implements CancellationRepository {

	public CancellationRepositoryImpl() {
		System.out.println("TransactionRepositoryImpl().....");
	}
	
	@Transactional
	public void insertCancellation(AirCancellation dRef) {
		super.persist(dRef);
	}

	@Transactional
	public AirCancellation selectCancellationbyid(int dno) {
		return super.find(AirCancellation.class, dno);
	}

	@Transactional
	public List<AirCancellation> selectAllCancellation() {
		System.out.println("selectall done");
		return super.findAll("AirCancellation");
	}

	@Transactional
	public void updatecancellation(AirCancellation dRef) {
		super.merge(dRef);
	}

	@Transactional
	public void deleteCancellation(int dno) {
		super.remove(AirCancellation.class, dno);
	}

}
