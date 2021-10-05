package com.example.demo.layer3.UserRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AirUser;




@Repository
public interface UserRepository { //DAO is known as Repository framework

	void insertUser(AirUser URef);
	void updateUser(AirUser URef);
	List<AirUser> selectUsersbyEmail(String emailId);
	AirUser SelectUserById(int userId);
	List<AirUser> selectAllUsers();
	//AirUser findById(int userId);
}
