package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.dto.Status;
import com.example.demo.dto.Status.StatusType;
import com.example.demo.layer3.UserRepository.UserRepositoryImpl;
import com.example.demo.model.AirUser;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepositoryImpl userRepo;
	

	public List<AirUser> findAllUsersService() {
		System.out.println("+++++++++++Find all Users Service is Running ++++++++++");
		return userRepo.selectAllUsers();
	}

	public void register(AirUser User) throws UserNotFoundException {
		if(!userRepo.isUserPresent(User.getEmailId())) {
			userRepo.insertUser(User);
			//String text="Successfully registered. Your id is "+id;
			//String subject="Registration Confirmation";
			//emailService.sendEmailForNewRegistration(customer.getEmail(), text, subject);
		}
		else
			throw new UserNotFoundException("User already registered!");
	}


	@Override
	public List<AirUser> findUserByEmailService(String emailId) {
		System.out.println("+++++++++++Find User Service by Email is Running ++++++++++");
		return  userRepo.selectUsersbyEmail(emailId);
	}
	
	public AirUser login(String emailId, String password) throws UserNotFoundException {
		try {System.out.println("In Login status");
		List<AirUser> u = userRepo.selectUsersbyEmail(emailId);
			if(u.isEmpty())
				throw new UserNotFoundException("User not registered!");
			AirUser found= u.get(0);
			System.out.println("found--1" + found.getPassword());
			System.out.println("found--1" + password);
			//long userId = userRepo.findByEmailAndPassword(emailId, password);
		//	AirUser user = userRepo.SelectUserById(userId);
			if( password.equals(found.getPassword())) {
				System.out.println("found" + found.getEmailId());
			   return found;}
			else {
				throw new UserNotFoundException("Incorrect email/password");
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("Incorrect email/password");
		}
	}

/*
	@Override
	public AirUser findUserByIdService(long UserId) {
		System.out.println("+++++++++++Find User Service by Id is Running ++++++++++");
		if(userRepo.SelectUserById(UserId).getEmailId()==null) {
			UserNotFoundException u = new UserNotFoundException("User not found "+UserId);
		}
			return userRepo.SelectUserById(UserId);	
	}
*/

	@Override
	public Status addNewUserService(AirUser URef) {
		Status sts=new Status();
		System.out.println("+++++++++++Insert User Service is Running ++++++++++");

		List<AirUser> findUser= userRepo.selectUsersbyEmail(URef.getEmailId());
		System.out.println(findUser);
			if(findUser.isEmpty()) {
			userRepo.insertUser(URef);	
			sts.setMessage("registration Success");
			sts.setStatus(StatusType.SUCCESS);
		}else {
			System.out.println("Email id Already Registered");
			sts.setMessage("email is already registered");
			sts.setStatus(StatusType.FAILURE);
		}
			return sts;
		
	}


	@Override
	public void updateUserPasswordService(AirUser URef) {
		System.out.println("+++++++++++Update User Service is Running ++++++++++");
		List<AirUser> findUser=  userRepo.selectUsersbyEmail(URef.getEmailId());
		if(!findUser.isEmpty()) {
			for(AirUser user : findUser) {
				user.setPassword(URef.getPassword());
			
		userRepo.updateUser(user);}
		}else {
			System.out.println("User Does not exist");
		}
	}


	@Override
	public void deleteUserService(long UserId) {
		System.out.println("+++++++++++Delete User Service by Id is Running ++++++++++");
		try {

			userRepo.deleteUser(UserId);

		System.out.println("+++++++++++++++ Object deleted..++++++++++++++");

		}

		catch(Exception e) {

		System.out.println(e.getMessage());

		}
		
	}




	

}
