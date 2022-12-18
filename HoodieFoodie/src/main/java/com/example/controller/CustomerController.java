package com.example.controller;


import com.example.exceptions.CustomerException;
import com.example.model.Customer;
import com.example.model.Restaurant;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;









@RestController
@RequestMapping("/hoodie")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer) throws CustomerException {
		Customer cust = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
	}
	
	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer customer,@RequestParam(required = false) String key) throws CustomerException {
		Customer cust = customerService.updateCustomer(customer, key);
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<Customer> deleteCustomerHandler(@PathVariable("customerId") String customerId) throws CustomerException {
		Customer cust = customerService.removeCustomer(customerId);
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
	}

	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> viewCustomerHandler(@PathVariable("id") String id)  throws CustomerException {
		Customer cust = customerService.viewCustomer(id);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);	
		
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> viewAllCustomerByRestaurantHandler(@RequestBody Restaurant rest) throws CustomerException{
		List<Customer> customerLists =customerService.viewAllCustomer(rest);
		return new ResponseEntity<>(customerLists,HttpStatus.FOUND);
	}
}
