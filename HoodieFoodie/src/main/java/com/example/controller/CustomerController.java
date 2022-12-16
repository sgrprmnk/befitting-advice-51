package com.example.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.CustomerException;
import com.example.model.Customer;
import com.example.model.Restaurant;
import com.example.service.CustomerService;









@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomerHandler(@Valid @RequestBody Customer customer) throws CustomerException {
		Customer cust = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
	}
	
	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomerHandler(@Valid @RequestBody Customer customer) throws CustomerException {
		Customer cust = customerService.updateCustomer(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/customer")
	public ResponseEntity<Customer> deleteCustomerHandler(@RequestBody Customer customer) throws CustomerException {
		Customer cust = customerService.removeCustomer(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
	}

	
	@GetMapping("/customer")
	public ResponseEntity<Customer> viewCustomerHandler(@RequestBody Customer customer) throws CustomerException {
		Customer cust = customerService.viewCustomer(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);	
		
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> viewAllCustomerByRestaurantHandler(@RequestBody Restaurant rest) throws CustomerException{
		List<Customer> customerLists =customerService.viewAllCustomer(rest);
		return new ResponseEntity<>(customerLists,HttpStatus.FOUND);
	}
}
