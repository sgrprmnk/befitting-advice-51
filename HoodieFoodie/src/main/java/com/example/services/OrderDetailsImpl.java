
package com.example.services;

import java. util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import hoodie.foodie.Exception.OrderDetailsException;
import hoodie. foodie.Module.Customer;
import hoodie. foodie.Module.OrderDetails;
import hoodie. foodie.Module.Restaurant;
import hoodie.foodie.Repo.OrderDetailsRepo;

public class OrderDetailsImpl implements OrderDetailsServices {

	@Autowired
	OrderDetailsRepo odr;
	@Override
	public OrderDetails addOrder(OrderDetails orderdertails) throws OrderDetailsException {
		OrderDetails od=odr.save(orderdertails);
		if(od==null) {
			throw new OrderDetailsException("Data not saved..");
		}else {
			return od;
		}
		
	}

	@Override
	public OrderDetails updateOrder(OrderDetails orderdetails) throws OrderDetailsException {
		 Optional<OrderDetails> opt=odr.findById(orderdetails.getOrderId());
		 if(opt.isPresent()) {
			 throw new OrderDetailsException("Your data not updated...");
		 }else {
			 OrderDetails od=opt.get();
			 odr.save(od);
			 return od;
		 }
		 
	}

	@Override
	public OrderDetails removeOrder(OrderDetails orderdetails) throws OrderDetailsException {
		Optional<OrderDetails> opt=odr.findById(orderdetails.getOrderId());
		if(opt.isPresent()) {
			OrderDetails od=opt.get();
			odr.delete(od);
			return od;
		}else {
			throw new OrderDetailsException("data not deleted...");
		}
	}

	@Override
	public OrderDetails viewOrder(OrderDetails orderdetails) throws OrderDetailsException {
		Optional<OrderDetails> opt=odr.findById(orderdetails.getOrderId());
		if(opt.isPresent()) {
			OrderDetails ood=opt.get();
			return ood;
		}else {
			throw new OrderDetailsException("data not found....");
		}
		
	}

	@Override
	public List<OrderDetails> viewAllOrdersByRestaurant(Restaurant restaurant) throws OrderDetailsException {
		List<OrderDetails> list=odr.findById(restaurant.getRestaurantId());
		if(list.isEmpty()) {
			throw new OrderDetailsException("Data not found...");
		}else {
			return list;
		}
		
	}

	@Override
	public List<OrderDetails> viewAllOrdersByCustomer(Customer customer) throws OrderDetailsException {
		
		List<OrderDetails> list=odr.findById(customer.getCustomerId());
		if(list.isEmpty()) {
			throw new OrderDetailsException("Data not found...");
		}else {
			return list;
		}
	}

	

	

}

