package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Address;
import com.example.model.Customer;



public interface CustomerDao extends JpaRepository<Customer, String> {
	public Customer findByEmail(String email);
	public List<Customer> findByAddress(Address add);

	public Customer findByMobileNumber(String mobileNumber);
	

}
