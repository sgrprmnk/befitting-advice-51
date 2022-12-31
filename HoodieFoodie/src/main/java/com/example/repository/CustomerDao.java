package com.example.repository;

import com.example.model.Address;
import com.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface CustomerDao extends JpaRepository<Customer, String> {
	public Customer findByEmail(String email);
	public List<Customer> findByAddress(Address add);

	public List<Customer> findByGender(String gender);
	public Customer findByMobileNumber(String mobileNumber);
	

}
