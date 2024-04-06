package com.movie.services;

import java.util.List;

import com.movie.models.Bookings;

public interface IBookingService {

	//Method to add new movie
	public int saveBooking(Bookings bk);
	
	//Method to get list of all the movies
	public List<Bookings> allBookings();
	
	//Method to get bookings list
	public List<Bookings> customerBookings(int cid);

	//Method to get all booked seat
	String getBookedSeats(int mid, int tid, int sid, String date);
		
	//Find the booking details by Id
	public Bookings findBookingDetails(int bid);
}

