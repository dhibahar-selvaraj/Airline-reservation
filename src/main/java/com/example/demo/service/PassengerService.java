package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.AirPassenger;
import com.example.demo.model.temppassengerticketbook;

@Service
public interface PassengerService {
	void setpassticketbook(temppassengerticketbook psk);
	AirPassenger addpassenger(AirPassenger ap);
	List<AirPassenger> getpassengers();
}
