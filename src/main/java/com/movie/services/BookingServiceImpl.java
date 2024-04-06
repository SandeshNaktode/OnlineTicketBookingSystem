package com.movie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.movie.models.Bookings;
import com.movie.repository.BookingRepo;

@Service
public class BookingServiceImpl implements IBookingService {

	//Dependency Injection
	@Autowired 
	BookingRepo brepo;
	@Autowired 
	CustomerServiceImpl cservice;
	
	//Method to add new movie
	@Override
	public int saveBooking(Bookings bk) {
		Bookings bb= brepo.save(bk);
		return bb.getBid();
	}
	
	//Method to get list of all the movies
	@Override
	public List<Bookings> allBookings(){
		return brepo.findAll(Sort.by(Direction.DESC, "bid"));
	}
	
	//Method to get bookings list
	@Override
	public List<Bookings> customerBookings(int cid){
		//getting booking details of a customer whose cid=?
		//resent booking show first
		return brepo.findByCustomerOrderByBidDesc(cservice.findById(cid));
	}
	
	//Method to get all booked seat
	@Override
	public String getBookedSeats(int mid,int tid,int sid,String date) {
		return brepo.getBookedSeats(mid,tid,sid, date);
	}
	
	//Find the booking details by Id
@Override
	public Bookings findBookingDetails(int bid) {
		return brepo.getById(bid);
	}

}
