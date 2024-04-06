package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.models.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	//1.Register new customer (save the data) 
	
	//2.Find the user by Id (finder method)
	
	//3.Get all customers (finder method)
}
