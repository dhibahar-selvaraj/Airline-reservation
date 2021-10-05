package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer3.CancellationRepository.CancellationRepository;
import com.example.demo.model.AirBooking;
import com.example.demo.model.AirCancellation;
import com.example.demo.model.AirUser;

@Service
public class CancellingServiceImpl implements CancellingService {

	@Autowired
	CancellationRepository cancelrepo;
	
	@Override
	public List<AirCancellation> getallcancellation() {
		return cancelrepo.selectAllCancellation();
	}

	@Override
	public List<AirCancellation> getallUsercancellation(AirUser au) {
		List<AirCancellation> resultlist=new ArrayList<AirCancellation>();
		AirUser d=(AirUser) au;
		List<AirBooking> lb=d.getAirBookings();
		for(AirBooking ab: lb) {
			if(ab.getBookingStatus().equals("cancelled")) {
				resultlist.add(cancelrepo.selectCancellationbyid(ab.getBookingId()));
			}
		}
		return resultlist;
	}

}
