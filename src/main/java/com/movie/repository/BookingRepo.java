package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.models.Bookings;
import com.movie.models.Customer;

@Repository
public interface BookingRepo extends JpaRepository<Bookings, Integer> {

	//1.Method to get booked seats
	@Query(value = "SELECT GROUP_CONCAT(seats) FROM bookings where movieid=?1 and theatreid=?2 and showid=?3 and bdate=?4",nativeQuery = true)
	String getBookedSeats(int mid,int tid,int sid,String date);
	
	//2.Method to find the list of bookings - Finder method
	List<Bookings> findByCustomerOrderByBidDesc(Customer customer);

}
