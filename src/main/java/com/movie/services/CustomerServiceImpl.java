package com.movie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.models.Customer;
import com.movie.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements ICustomerService{

	//Dependency Injection
	@Autowired CustomerRepo crepo;
	
	//Add new customer
	@Override
	public Customer saveCustomer(Customer cust) {
		return crepo.save(cust);
	}
	
	//Getting the customer object by using id
	@Override
	public Customer findById(int id) {
		return crepo.getById(id);
	}
	
	//Get the list of all the customers 
	@Override
	public List<Customer> allCustomers(){
		return crepo.findAll();
	}
}
