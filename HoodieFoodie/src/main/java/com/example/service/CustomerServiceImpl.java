package com.example.service;

import com.example.exceptions.CustomerException;
import com.example.model.CurrentUserSession;
import com.example.model.Customer;
import com.example.model.Restaurant;
import com.example.repository.CustomerDao;
import com.example.repository.SessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private SessionDao sessionDao;


	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = customerDao.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			throw new CustomerException("Customer Already Exist ....");
		}
		
		return customerDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer,String key) throws CustomerException {
		CurrentUserSession loggedInUser=sessionDao.findByUuid(key);
		if (loggedInUser==null){
			throw new CustomerException("Please provide a valid key to update");
		}

		//Optional<Customer> opt = customerDao.findById(customer.getCustomerId());
		if(customer.getCustomerId().equals(loggedInUser.getUserId())) {
			return customerDao.save(customer);
		}
		throw new CustomerException("No Customer Exist with this Data");
	}

	@Override
	public Customer removeCustomer(String customerId) throws CustomerException {
		// TODO Auto-generated method stub
		Optional<Customer> customer1= customerDao.findById(customerId);
		if(customer1.isPresent()) {
			Customer existC=customer1.get();
			customerDao.delete(existC);
			
			return existC;
		}
	throw new CustomerException("No Customer Exist");
		
	}

	@Override
	public Customer viewCustomer(String customerId) throws CustomerException {
		return customerDao.findById(customerId).orElseThrow(()-> new CustomerException("Customer not Found"));
	}
//	@Override
//	public Customer viewCustomer(String cID) throws CustomerException {
//		Optional<Customer> opt = customerDao.findById(cID);
//		if(opt.isPresent()) {
//			return opt.get();
//		}
//		throw new CustomerException("No Customer Exist");
//	}

	@Override
	public List<Customer> viewAllCustomer(Restaurant rest) throws CustomerException {
		// TODO Auto-generated method stub
List<Customer> customers=customerDao.findByAddress(rest.getAddress());

if(customers.isEmpty()) {
	throw new CustomerException("Customer Not find");
}
		return customers;
	}


	

}
