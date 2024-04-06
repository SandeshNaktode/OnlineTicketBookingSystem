package com.movie.services;

import java.util.List;

import com.movie.models.Customer;

public interface ICustomerService {

	//Add new customer
	Customer saveCustomer(Customer cust);

	//Getting the customer object by using id
	public Customer findById(int id);
	
	//Get the list of all the customers 
	public List<Customer> allCustomers();
}
