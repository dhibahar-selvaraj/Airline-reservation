package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.dto.Status;
import com.example.demo.model.AirUser;


@Service
public interface UserService {
		List<AirUser> findUserByEmailService(String emailId);
		List<AirUser> findAllUsersService();
		//public AirUser findUserByIdService(long UserId);
		Status addNewUserService(AirUser URef);
		void updateUserPasswordService(AirUser URef);
		void deleteUserService(long UserId);
		AirUser login(String emailId, String password) throws UserNotFoundException;
}
