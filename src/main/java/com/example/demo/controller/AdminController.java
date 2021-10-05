package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.LoginStatus;
import com.example.demo.dto.Status;
import com.example.demo.dto.Status.StatusType;
import com.example.demo.model.AirAdmin;
import com.example.demo.model.AirFlight;
import com.example.demo.model.AirUser;
import com.example.demo.service.AdminServiceImpl;
import com.example.demo.service.FlightService;

@CrossOrigin("*")
@RestController
public class AdminController {

	@Autowired
	AdminServiceImpl adminserv;
	
	
//	@PostMapping
//	@RequestMapping(path="/cancellingflight")
//	public void addCancel(@RequestBody AirFlight flight)
//	{
//		System.out.println("flight cancelling is called ");
//		adminserv.deleteflight(flight);
//	}
	
	@PostMapping
	@RequestMapping(path="/loginadmin")  
	public Boolean addflight(@RequestBody LoginDTO sts) throws UserNotFoundException
	{
			AirAdmin admin = adminserv.login(sts.getEmailId(), sts.getPassword());
			if(admin.getAdminId()!=null) {
				return true;
			}
			return false;
	}
	
	@PostMapping
	@RequestMapping(path="/addflight")  
	public void addflight(@RequestBody AirFlight flight)
	{
		System.out.println("flight addition is called ");
		adminserv.insertflight(flight);
	}
	
	@RequestMapping(path="/getallflight")  
	public List<AirFlight> getflight()
	{
		System.out.println("flight collection is called ");
		return adminserv.getallflights();
	}
	
	@RequestMapping(path="/getallcancelledflight")  
	public List<AirFlight> getallcancelledflight()
	{
		System.out.println("flight collection is called ");
		return adminserv.getallcancelledflights();
	}
	
	@RequestMapping(path = "/admin/cancelFlight/{fId}")
	public void cancelFlight(@PathVariable int fId){
		adminserv.cancelFlightByAdminService(fId);
	}
}
