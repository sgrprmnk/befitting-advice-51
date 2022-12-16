package com.example.service;

import java.util.List;

import com.example.exceptions.CustomerException;
import com.example.model.Customer;
import com.example.model.Restaurant;

public interface CustomerService {
public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
	public Customer removeCustomer(Customer customer) throws CustomerException;
	
	public Customer viewCustomer(Customer customer) throws CustomerException;
	
	public List<Customer> viewAllCustomer(Restaurant rest) throws CustomerException;

}
