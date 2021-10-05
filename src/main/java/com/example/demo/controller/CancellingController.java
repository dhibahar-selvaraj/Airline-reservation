package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer3.BookingRepository.BookingRepository;
import com.example.demo.layer3.CancellationRepository.CancellationRepository;
import com.example.demo.layer3.UserRepository.UserRepository;
import com.example.demo.model.AirBooking;
import com.example.demo.model.AirCancellation;
import com.example.demo.model.AirUser;
import com.example.demo.service.CancellingService;

@CrossOrigin("*")
@RestController
public class CancellingController {
	
	@Autowired
	UserRepository userrepo;

	@Autowired
	CancellingService cancelserv;
	
	@RequestMapping(path="/getallcancellation")
	public List<AirCancellation> getallcancellation() {
		System.out.println("cancellation called");
		return cancelserv.getallcancellation();
	}
	
	@PostMapping
	@RequestMapping(path="/getallusercancellation")
	public List<AirCancellation> getallusercancellation(@RequestBody AirUser au) {
		System.out.println("cancellation called");
		return cancelserv.getallUsercancellation(userrepo.SelectUserById((int)au.getUserId()));
	}
	
}
