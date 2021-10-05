package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.LoginStatus;
import com.example.demo.dto.Status;
import com.example.demo.dto.Status.StatusType;
import com.example.demo.model.AirUser;
import com.example.demo.service.UserServiceImpl;




@CrossOrigin(origins = "*", value = "*")
@RestController
public class UserJPAController {
	
@Autowired
UserServiceImpl userService;

public UserJPAController() {

	System.out.println("UserJPAController()....");
	
}

@GetMapping //DONE 
@RequestMapping(path="/getJPAUser/{email}") // localhost:8080/getJPAUser/anu@gmail.com
public AirUser getUser(@PathVariable("email") String emailId) throws UserNotFoundException
{
	System.out.println("getUser : "+emailId);
	List<AirUser> foundUser = userService.findUserByEmailService(emailId);
			
	for(AirUser user : foundUser) {
	if(user == null) {
		UserNotFoundException d = new UserNotFoundException("User Email Id Not Found "+emailId);
	}

	return user;
}
	return null;

	
}
/*
@GetMapping //DONE 
@RequestMapping(path="/getJPAUserById/{id}") // localhost:8080/getJPAUser/anu@gmail.com
public AirUser getUser(@PathVariable("id") long id) throws UserNotFoundException
{
	System.out.println("getUser : "+id);
	AirUser foundUser = userService.findUserByIdService(id);
			
		if(foundUser == null) {
		UserNotFoundException d = new UserNotFoundException("User Id Not Found "+id);
		
	

	return foundUser;
}
	return null;

	
}*/

@DeleteMapping///DONE
@RequestMapping(path="/deleteJPAUser/{id}") // 
public void deleteUser(@PathVariable("id")  long id) throws UserNotFoundException 
{	
	boolean found=false;
	userService.deleteUserService(id);
	found=true;
			
	if(found) {
		System.out.println("Dept Deleted");
	}
	else {
		System.out.println("Not found");
		UserNotFoundException UserNotFoundEx = new UserNotFoundException("User Id Not Found "+id);
		throw UserNotFoundEx;
	}
	
}

@GetMapping //Done
@RequestMapping(path="/getJPAUsers") 
public List<AirUser> getAllAirUsers() {
	System.out.println("getAllAirUsers");
	return userService.findAllUsersService();
}
/*
@PostMapping//Done
@RequestMapping(path="/addJPAUser/") 
public void addUser(@RequestBody AirUser addUser) throws UserNotFoundException 
{
	AirUser newUser = new AirUser();
	newUser.setEmailId(addUser.getEmailId());
	newUser.setPhNo(addUser.getPhNo());
	newUser.setDob(addUser.getDob());
	newUser.setFirstName(addUser.getFirstName());
	newUser.setLastName(addUser.getLastName());
	newUser.setPassword(addUser.getPassword());
	userService.addNewUserService(newUser);
	
}*/
Status sts= new Status();

@PostMapping(path = "/register")
public Status register(@RequestBody AirUser user) {
	try {
		sts.setMessage("email is already registered");
		sts.setStatus(StatusType.FAILURE);
		return userService.addNewUserService(user);
	}
	catch(Exception e) {
		return sts;
	}

}

@PostMapping("/login")
public LoginStatus login(@RequestBody LoginDTO loginDto) {
	try {
		AirUser user = userService.login(loginDto.getEmailId(), loginDto.getPassword());
		LoginStatus loginStatus = new LoginStatus();
		loginStatus.setStatus(StatusType.SUCCESS);
		loginStatus.setMessage("Login Successful!");
		loginStatus.setFirstName(user.getFirstName());
		loginStatus.setLastName(user.getLastName());
		loginStatus.setUser(user);
		System.out.println(user.getEmailId());
		return loginStatus;
	}
	
	catch(UserNotFoundException e) {
		LoginStatus loginStatus = new LoginStatus();
		loginStatus.setStatus(StatusType.FAILURE);
		loginStatus.setMessage(e.getMessage());
		System.out.println(e);
		return loginStatus;
	}
}



public LoginStatus Adminlogin(@RequestBody LoginDTO loginDto) {
	try {
		AirUser user = userService.login(loginDto.getEmailId(), loginDto.getPassword());
		LoginStatus loginStatus = new LoginStatus();
		loginStatus.setStatus(StatusType.SUCCESS);
		loginStatus.setMessage("Login Successful!");
		loginStatus.setFirstName(user.getFirstName());
		loginStatus.setLastName(user.getLastName());
		loginStatus.setUser(user);
		System.out.println(user.getEmailId());
		return loginStatus;
	}
	
	catch(UserNotFoundException e) {
		LoginStatus loginStatus = new LoginStatus();
		loginStatus.setStatus(StatusType.FAILURE);
		loginStatus.setMessage(e.getMessage());
		System.out.println(e);
		return loginStatus;
	}
}

@PatchMapping//Done
@RequestMapping(path="/updateJPAUserPassword/") 
public void updateUser(@RequestBody AirUser newUser) throws UserNotFoundException 
{	userService.updateUserPasswordService(newUser);
	
}

}
