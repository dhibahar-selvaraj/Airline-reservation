package com.example.demo.layer3.BookingRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AirBooking;
import com.example.demo.model.AirUser;




@Repository
public interface BookingRepository { //DAO is known as Repository framework
	void insertBooking(AirBooking dRef);
	AirBooking selectBookingbyid(int dno);
	List<AirBooking> selectAllBooking();
	void updateBooking(AirBooking dRef);
	void deleteBooking(int dno);
	List<AirBooking> selectAllUserBooking(AirUser user);
}
//interface DeptRepository cannot be instantiated
//but the child of this interface can be innstantiated
