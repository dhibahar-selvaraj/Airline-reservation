package com.example.demo.layer3.AdminRepository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.BaseRepository;
import com.example.demo.model.AirAdmin;



@Repository("adminrepo")
public class AdminRepositoryImpl extends BaseRepository implements AdminRepository {

	public AdminRepositoryImpl() {
		System.out.println("TransactionRepositoryImpl().....");
	}
	
	@Transactional
	public AirAdmin selectAdminbyid(String dno) {
		return super.find(AirAdmin.class, dno);
	}

}
