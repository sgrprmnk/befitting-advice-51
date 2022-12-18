package com.example.service;

import com.example.exceptions.CustomerException;
import com.example.model.Customer;
import com.example.model.Restaurant;

import java.util.List;

public interface CustomerService {
public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer, String key) throws CustomerException;
	
	public Customer removeCustomer(String customerId) throws CustomerException;
	
	public Customer viewCustomer(String customerId) throws CustomerException;
	
	public List<Customer> viewAllCustomer(Restaurant rest) throws CustomerException;

}
