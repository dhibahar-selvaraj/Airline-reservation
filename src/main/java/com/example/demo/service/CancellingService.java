package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.AirCancellation;
import com.example.demo.model.AirUser;

@Service
public interface CancellingService {
	List<AirCancellation> getallcancellation();
	List<AirCancellation> getallUsercancellation(AirUser au);
}
