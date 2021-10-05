package com.example.demo.layer3.BookingRepository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.BaseRepository;
import com.example.demo.model.AirBooking;
import com.example.demo.model.AirUser;


@Repository("bookingrepo")
public class BookingRepositoryImpl extends BaseRepository implements BookingRepository {

	public BookingRepositoryImpl() {
		System.out.println("TransactionRepositoryImpl().....");
	}
	
	@Transactional
	public void insertBooking(AirBooking dRef) {
		super.persist(dRef);
	}

	@Transactional
	public AirBooking selectBookingbyid(int dno) {
		return super.find(AirBooking.class, dno);
	}

	@Transactional
	public List<AirBooking> selectAllBooking() {
		System.out.println("selectall done");
		return super.findAll("AirBooking e where e.bookingStatus = 'succeded' ");
	}

	@Transactional
	public void updateBooking(AirBooking dRef) {
		super.merge(dRef);
	}

	@Transactional
	public void deleteBooking(int dno) {
		super.remove(AirBooking.class, dno);
	}

	@Transactional
	public List<AirBooking> selectAllUserBooking(AirUser user) {
		return super.findAll("AirBooking e where e.bookingStatus = 'success'");
	}

}
